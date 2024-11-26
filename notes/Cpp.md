# WORKING WITH POINTERS AND ARRAYS IN C++ 20
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