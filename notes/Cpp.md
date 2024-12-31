# WORKING WITH POINTERS AND ARRAYS IN C++ 20

# 5. Pointing to Class Members
Module 5:
![alt text](image-40.png)
## 5.1. Accessing Class Members with the Arrow Operator
![alt text](image-41.png)
- The compiler evaluates the **dot operator** `.` before the **dereference operator** `*`
- So if you want to **dereference** first then access the members of the object, make sure you put the dereference in **parenthesis** `(*pointerName)`
- But this(code in above image) syntax is hard to read
- So, we can use the **member-of operater** `->` instead :

![alt text](image-42.png)
- That is why C++ also offers us the **member-of operater** `->`
- It's like saying *dereference the pointer to an object THEN access a member* `pointerToAnObject->member`
- dereference THEN access
- -> ==  dereference `-`,  THEN access `>`
- It's a shortcut from:
- *pointer.member ==  dereference `*pointerName`, THEN access `.`

## 5.2. Using Base Class Pointers as an Interface
### Summary
![alt text](image-44.png)
- If you ever need `virtual functions` in your classes, always define a `virtual destructor` to prevent **memory leaks**.

### Start
**Base Class:**
![alt text](image-57.png)

**Derived Classes:**
![alt text](image-46.png)
![alt text](image-45.png)

**Main Class:**
![alt text](image-58.png)

#### If ~Destructor is not made virtual 
If you don't make the **destructor** virtual, when you call delete on a derived class/object , the delete call will only delete the base class' stuff and leave the derived guys. This leads to memory leaks.
e.g. :
**Modified Main Class:**
![alt text](image-47.png)
![alt text](image-50.png)
![alt text](image-49.png)
Delete will only delete the Base part from each of these objects. 
This is because the compiler will still use **`Early Binding`** to access these objects.
The dangling members from the derived classes will stay in memory and cause a serious memory leak.

**To fix this:**

Do the same thing we did to the *play* function.
We need to implement **`Late Binding`**
And we can do that by making the *Base Destructor* virtual.
![alt text](image-44.png)

Note:
But in this case, the lesson instructor didn't even create *Derived Destructors*.
I guess because the base one was enough.
Since it was going to be inherited by the derived classes.
Look at the picture, in his code, he placed everything in the public section.

### Why we need the Virtual feature
If we have a hierachy of classes (like from his code), we can use the Base class as an interface.
e.g.:
![alt text](image-51.png)
**Inheritance** and **Late Binding** allow us to group Derived classes in a single array of Base class pointers.


(In his Cose) Since it makes no sense to have a general `Instrument` object, he turned the Base class into an **Abstract class** (by removing the play function definition and assigning it to 0) :
![alt text](image-52.png)
This makes the function a **Pure Virtual Function**.
And every class that has a *Pure Virtual Function* is known as an **Abstract class**
- *which is another word for an `Interface` in C++*

Basically, *Abstract classes* cannot be instantiated.
- *which makes sense for him coz he doesn't need an unspecified instrument*

![alt text](image-53.png)
![alt text](image-54.png)

Here is another use case for the Instrument Interface:
![alt text](image-55.png)
If we didn't have this, we would have to overload this function for every type of Instrument.
Or we would be forced to make a **Templated Function**

##### Prevent Memory Leaks:
And finally we cannot forget to create another loop to delete each one of these Instruments from the Heap :
![alt text](image-56.png)
So:
 If you ever need `virtual functions` in your classes, always define a `virtual destructor` to prevent **memory leaks**.

 ## 5.3. Virtual Tables and Virtual Pointers
 A brief discussion/demonstration on how C++ implements **Late Binding** to support the existence of **Virtual Functions**.

 Virtual Functions introduce a small overhead in the size of a class.

 For this demonstration, we are going to bring back the definition of the `play()` function :
 ![alt text](image-59.png)
#### The previous base class and derived classes
![alt text](image-60.png)
When you mark some function as `virtual`, program will create a `virtual table` in memory for the class that contains that **virtual function**:
![alt text](image-61.png)
![alt text](image-62.png)
This virtual table is nothing more than **a simple array of pointers**, specifically: pointers to functions.
Each position in that array is dedicated to a virtual function.
![alt text](image-63.png)

Since derived functions could override this function from the base class, they also get their own virtual tables:
![alt text](image-64.png)
We know that each of these classes have their own version of the play function:
![alt text](image-65.png)
And the instructions for executing these functions are also stored in a special part of memory.

These functions from the virtual table should point to the appropriate function in memory:
![alt text](image-66.png)
Since every class in this example has its own function override, these pointers point to the function defined inside of that class.

So let's say I want to call the `play()` function from the **Instrument pointer**, which actually points to the **Guitar object**:
![alt text](image-67.png)
Before executing the function, C++ will check the virtual table of the object; which in this case, is the object of the Guitar class:
![alt text](image-68.png)
Compiler knows that the position of this function pointer is 0:
![alt text](image-70.png)
So it will use this function pointer to find the correct function in memory:
![alt text](image-69.png)

Once it finds the correct function, it will **Bind** it to the highlighted/current statement:
![alt text](image-71.png)
And call the corret `play()` function from memory.
This is why we call it **Late Binding** 
*Because the function is Bound at the time of execution (at Runtime)*

------
But what if I decide to remove this overriden function from the **Synth** derived class:
![alt text](image-72.png)
The Virtual Table from this class:
![alt text](image-73.png) 
will see that we don't have the appropriate overide
So by default, this function pointer will point to the function defined in the Base Instrument class:
![alt text](image-74.png)

And now when we try to call this `play()` function on the **Synth object** through the **Instrument pointer**:
![alt text](image-75.png)
The Virtual Table will be checked again:
![alt text](image-76.png)
And this pointer:
![alt text](image-77.png)
will tell the program to execute the function from the Base Instrument class:
![alt text](image-78.png)

So these Virtual Tables will help the program find the correct Virtual Function in memory.
And we don't have to manage these tables (the program manages them itself).
The **overhead** that I was talking about is the existence of the **virtual pointer**.

---
Whenever you define a virtual function, that base class and all of its derived classes need to store another hidden member, which is known as the **Virtual Pointer**:
![alt text](image-79.png)
We don't manage this pointer, but we have to be aware that it increases the size of the overall class. 
The only purpose of this hidden pointer is to point to the virtual table that belongs to that class:
![alt text](image-80.png)
This is how a program gets access to the correct virtual table. 
And this pointer :
![alt text](image-81.png)
is inherited just like any other member of the base class, so all of the derived classes also have it. 

So let's say again that I'm calling the play() function from the Instrument pointer, which points to the Guitar object: 
![alt text](image-82.png)
This above highlighted pointer is only aware of the inherited part of this Guitar object.
![alt text](image-83.png)
As far as this pointer is concerned, this object `new Guitar(true)` is actually an instrument and it only has these two members, the Boolean value and the virtual pointer, because the number of strings is not inherited.

But that's great because the Instrument pointer is still aware of this virtual pointer member:
![alt text](image-84.png)
and since this pointer belongs to the Guitar object, that means that it is pointing to the Guitar's virtual table:
![alt text](image-85.png)
And since the Guitar's virtual table has the correct function pointer, the overridden function will be used:
![alt text](image-86.png)

---
**The part about the Overhead:** Look at the images below
![alt text](image-88.png)
![alt text](image-89.png)
![alt text](image-90.png)
Before virtual functions, the Instrument needed only one byte of data. And now you can see that all of these objects suddenly need 16 bytes of memory.

Since the virtual pointer is just a pointer, each class would need an additional 8 bytes of memory, at least on my 64‑bit computer.
![alt text](image-87.png)

So Before, if the Instrument class only required 1 byte, shouldn't the total size now be 9 bytes(and not 16 bytes)? 
Yes, but the reason for this big increase is the occurrence of something known as **structure padding**.

As I mentioned, all of the object members have to be stored next to each other in one block of memory. But the total size of this block will depend on the alignment of data.

In essence, CPU works by processing data in cycles:
![alt text](image-91.png)
, and a so‑called **word length** determines the maximum amount of bytes that it can process in each cycle.
On 32‑bit machines, this word length is 4 bytes, and on 64‑bit machines, like mine, it's 8 bytes:
![alt text](image-92.png)
To achieve better performance, the data from an object is aligned by the computer:
![alt text](image-93.png)

If we just put members next to each other, Instrument class would only need 9 bytes, but this virtual pointer would be split in two parts. CPU prefers to read whole values in one cycle. To make this happen, the program will move this pointer into the next block of 8 bytes and add 7 padding bytes next to the Boolean:
![alt text](image-94.png)
Now we can read the Boolean in one cycle and the whole pointer in the next one. 

And the same goes for the derived classes:
![alt text](image-95.png)
Their virtual pointer is also moved to the next cycle, but the Boolean and the integer member are both available in the first cycle:
![alt text](image-96.png)

If you remove the virtual functions and check the size of the Guitar or Synth class, you might be surprised that it's 8 bytes instead of 5:
![alt text](image-97.png)
This is because the processor also likes to have data aligned in a way that *every data type starts at an increment of its own size.*
In this case, an integer of 4 bytes should either start at the beginning of an 8‑byte sequence or at least at the middle.
So the computer adds 3 padding bytes to make this happen:
![alt text](image-99.png)

I should note that this is not a language feature. Padding is implemented by the compiler, and just because it works like this on my computer, that doesn't mean that yours will do the same. The point of this little digression was to show you how this virtual pointer: 
![alt text](image-100.png)
can possibly increase the size of your objects, in this case, significantly. So don't use virtual functions just because the cool kids are doing it; approach them wisely.

### 5.3.Q.1. What is Late Binding
C++ implements **late binding** to support the existence of **virtual functions**. 
So does **late binding** occur at runtime THEN **early binding** at compile time?

Response:
To answer your question based on the diagram and your description:

**Late binding** (or dynamic dispatch) occurs **at runtime**, which is the process of resolving the correct function to call through the virtual table (vtable). 

In the case of **virtual functions**, the compiler performs the following actions during **compile time** (early binding phase):
1. **Sets up the vtable structure**: The compiler generates a vtable for each class that has virtual functions. This vtable maps function pointers to the correct implementation based on the class hierarchy.
2. **Associates the vtable with objects**: Each polymorphic object (an object of a class with virtual functions) contains a hidden pointer (`vptr`) that points to the vtable of the actual type of the object.
3. **Emits code for indirect calls**: For calls to virtual functions, the compiler generates code that accesses the `vptr` to locate the correct function pointer in the vtable.

At **runtime**, the **late binding** occurs when:
- The program accesses the vtable via the `vptr` and invokes the appropriate function pointer stored in the table. This allows the correct overridden function to be called based on the actual type of the object, even if the call is made through a base class pointer.

In summary:
- **Early binding** at compile time: The vtable is set up, and the `vptr` logic is incorporated into the program.
- **Late binding** at runtime: The function call is resolved dynamically via the vtable, allowing polymorphism to work.



## 5.4. Revisiting RAII
```c++
#include <iostream>

class DNA {
    public:
        // 60'000'000 bytes = 60 megabytes
        char code[60'000'000];

        DNA(const char *str) {
            for(int i = 0; i < 4; i++) {
                code[i] = str[i];
            } 
        }

        void printGeneticCode() {
            for(int i = 0; i < 4; i++) {
                std::cout << code[i];
            }
            std::cout << std::endl;
        }
};

//instead of having DNA in Subject, like this:
// class Subject {
//     public:
//         int subject_id;
//         DNA sample;
// };

class Subject {
    public:
        int subject_id;
        DNA *sample;

        Subject(): subject_id(0), sample(new DNA("0000")) {}
        // NOT like this:
        //Subject(int si, const char *str): subject_id(si), DNA(str) {}

        // I want to pass this string literal pointer to the DNA object, but the object doesn't exist yet, we only have an empty sample pointer.
        // So inside of this constructor, we actually need to allocate space on the heap for this DNA object and store its location inside of the sample pointer.

        Subject(int si, const char *str): subject_id(si), sample(new DNA(str)) {}

        //  this is where we need to start thinking about all of the side effects from using pointers as data members. Since we allocated this DNA resource inside of the constructor, we need to deallocate it inside of the destructor. 

        ~Subject() { 
            delete sample;
        }

        void printSubjectData() {
            std::cout << "ID  : " << subject_id << std::endl;
            std::cout << "DNA : ";
            sample->printGeneticCode();
            std::cout << std::endl;
        }
};

// version of main() that WON'T work
// int main() {
//     DNA sample;

//     return 0;
//     // program won't be able to instantiate sample on the stack
//     // coz 60MB can't fit in the stack
// }

// version of main() that WILL work
int main() {
    DNA *sample = new DNA("CGTA");
    sample->printGeneticCode();
    return 0;

    Subject sheep(3, "CGTA");
    sheep.printSubjectData();
}

```

#### Version of main() that WON'T work
![alt text](image-101.png)

#### Version of main() that WILL work
We learned in one of the previous lessons that we can pass the string literal to a function by using the constant pointer to a char value. It has to be constant because the string literal is in a read only part of memory.

Q. But `str` is a character pointer, so why is he using the square-bracket notation to access the elements?
R. ???

---

## 5.5. Implementing Copy Semantics


---

# Kate Gregory stuff
### Why Does **Uniform Initialization** Exist in C++?

**Uniform initialization** was introduced in **C++11** to address several inconsistencies and limitations in how objects were traditionally initialized in C++. Previously, C++ had multiple syntaxes for initialization (`()` for constructors, `{}` for aggregates, `=` for assignments), which often led to confusion, ambiguity, and unexpected behavior. 

---

### 🚀 **Problems with Traditional Initialization Syntaxes**

1. **Multiple Initialization Forms**  
    ```cpp
    int a = 5;       // Copy initialization
    int b(5);        // Direct initialization
    int c{5};        // Uniform initialization (C++11)
    ```

   - Different syntax for initializing the same object type.

2. **Ambiguity in Constructor Overload Resolution**  
    ```cpp
    class Example {
    public:
        Example(int x) {}
        Example(std::initializer_list<int> list) {}
    };

    Example e1(5);  // Calls int constructor
    Example e2{5};  // Calls initializer_list constructor
    ```

   - The `{}` syntax allowed more predictable overload resolution.

3. **Narrowing Conversions**  
    - Traditional initialization allowed **narrowing conversions**, which could lead to silent data loss:
    ```cpp
    double x = 3.14;
    int y(x);  // Allowed, but dangerous
    int z{3.14};  // Error: Narrowing conversion not allowed
    ```

4. **Aggregate and POD Initialization Confusion**  
    ```cpp
    struct Data { int x; int y; };
    Data d1 = {1, 2};  // Works
    Data d2(1, 2);     // Error
    Data d3{1, 2};     // Works in C++11
    ```

---

### ✅ **Benefits of Uniform Initialization**

1. **Consistency Across All Types**
   - `{}` syntax works for **primitives, classes, STL containers, and aggregates**.

2. **Prevention of Narrowing Conversions**
   - `{}` prevents silent data loss from implicit narrowing conversions.

3. **Improved Constructor Overload Resolution**
   - `{}` syntax helps distinguish between constructors with different signatures, like `std::initializer_list`.

4. **Simpler and More Readable Syntax**
   - One initialization style reduces cognitive overhead when switching between different object types.

5. **Works with `auto` and Templates**
   - `{}` can be combined with `auto` effectively:
     ```cpp
     auto x = {1, 2, 3};  // std::initializer_list<int>
     ```

---

### 📚 **Examples**

```cpp
int a{5};  // Preferred over int a = 5;

std::vector<int> vec{1, 2, 3};  // Cleaner syntax

struct Point { int x; int y; };
Point p{10, 20};  // Uniform initialization
```

---

### 🔑 **Conclusion**

Uniform initialization exists to:
- Eliminate ambiguities from traditional initialization methods.
- Make initialization syntax consistent across the language.
- Prevent unsafe implicit conversions.
- Improve code clarity and robustness.

It is now considered **best practice** to use uniform initialization (`{}`) whenever possible in modern C++.

---

### 🤔 **Why Do People Still Use Direct Initialization in Constructor Definitions?**

When defining constructors in C++, you’ll often see **direct initialization** syntax (`()` or `: member(value)`) in initializer lists, even though **uniform initialization** (`{}`) exists. This happens for several practical reasons:

---

## 🚀 **1. Uniform Initialization Doesn't Work in All Contexts**

### **Direct Initialization in Member Initializer Lists**

- In **member initializer lists**, the syntax uses direct initialization `()` or assignment-style `=`.
  
```cpp
class Person {
public:
    int age;
    std::string name;

    // Constructor with Direct Initialization
    Person(int a, std::string n) 
        : age(a), name(n) {}
};
```

- **Why not `{}`?**
   - Uniform initialization (`{}`) has ambiguity when constructors accept `std::initializer_list`.  
   - `std::initializer_list` constructor might get picked unexpectedly.

**Problem Example:**
```cpp
class Example {
public:
    Example(int value) {}
    Example(std::initializer_list<int> list) {}
};

Example e{42};  // Ambiguous! Which constructor is called?
Example e(42);  // Clear! Calls int constructor.
```

- This ambiguity makes developers prefer **direct initialization** for clarity.

---

## ✅ **2. Clarity and Readability**

- Direct initialization in constructors aligns with older and widely adopted C++ conventions.
- When initializing primitive types or members without ambiguity, direct initialization is more concise and readable.

**Example:**
```cpp
Person::Person(int a, std::string n)
    : age(a), name(n) {}  // Clear and concise
```

If `{}` were used:
```cpp
Person::Person(int a, std::string n)
    : age{a}, name{n} {}  // Also valid, but less common in practice
```

Both are valid, but `()` feels more natural in member initializer lists.

---

## ⚠️ **3. Brace-Initialization Pitfalls**

- Uniform initialization can **fail silently** if there’s no matching constructor.
- Sometimes `{}` doesn’t behave as expected in edge cases.

**Example:**
```cpp
std::vector<int> v1(5);   // 5 default-initialized integers
std::vector<int> v2{5};   // A vector with one integer: 5
```

- These subtle differences can cause bugs if misunderstood.

---

## 🛠️ **4. Historical and Community Convention**

- C++ developers are accustomed to using direct initialization in member initializer lists.
- Existing codebases overwhelmingly use direct initialization for constructors.

Switching entirely to uniform initialization would require significant refactoring and could introduce subtle bugs.

---

## 📚 **Best Practices**

1. Use **Direct Initialization (`()`)** in member initializer lists unless there’s a specific reason to use `{}`.
2. Use **Uniform Initialization (`{}`)** in local variables or when constructing objects where narrowing conversions must be prevented.
3. Avoid mixing the two styles arbitrarily—stick to a consistent style.

**Example of Modern Constructor:**
```cpp
class Person {
    int age;
    std::string name;

public:
    Person(int a, std::string n)
        : age(a), name(n) {}  // Clear and follows conventions
};
```

If there’s no ambiguity, using `{}` in member initializer lists is fine:
```cpp
Person(int a, std::string n)
    : age{a}, name{n} {}  // Also valid, slightly more strict
```

---

### 🔑 **Conclusion**

- Direct initialization (`()`) remains the **preferred choice** in constructor definitions and member initializer lists due to clarity, consistency, and historical conventions.
- Uniform initialization (`{}`) is excellent for general-purpose variable initialization and preventing narrowing conversions but can introduce ambiguity in constructors with `std::initializer_list`. 

When in doubt, **follow the conventions of the codebase you’re working in.** 😊