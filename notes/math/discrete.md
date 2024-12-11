# Discrete Mathematics
## Learning Plan
1. The Basic Concepts of Dis. Math
2. Applying (aka Implementing) Dis. Math in Computer Science (and Data Science)

## Basic Concepts and Definition
Discrete Mathematics is the study of **countable** *mathematical structures*.
Discrete Mathematics is the study of **distinct** *mathematical structures*.
Discrete Mathematics is the study of **separate** *mathematical structures*.

Examples of objects studied in Dis. Math:
- Logical statements
- Graphs
- Networks
- Bits and Bytes

The above listed things can form intricate patterns which we can exploit for various purposes related to Computer (and Data) Science.

- You need to understand the principles of Discrete mathematics in order to understand the underlying ideas of Computer Algorithms.
- You need to understand the principles of Discrete mathematics in order to understand the underlying ideas of Software Development / Programming Languages.

## Set Theory
### **Why can't real numbers be listed within braces?**
**Question:**

Look at the section `Example: some examples of sets.` 

![alt text](image.png)

It says it is not possible to list the Real numbers within braces, as we can with N or Z.
My question is why not?
And what are the differences in meaning between braces and parentheses and square brackets in Set Theory?
Do the have other meaning when I make the face different directions? E.g. ] 1, 5]

**Response:**

Real numbers (\(\mathbb{R}\)) cannot be listed within braces because they form an **uncountable infinite set**. Unlike natural numbers (\(\mathbb{N}\)) or integers (\(\mathbb{Z}\)), which are **countable**, real numbers include an infinite number of elements between any two numbers (e.g., all the decimals between \(0\) and \(1\)). Therefore, it's impossible to explicitly write down all the elements of \(\mathbb{R}\) within braces.

In contrast:
- \(\mathbb{N} = \{1, 2, 3, \dots\}\): Countable.
- \(\mathbb{Z} = \{\dots, -3, -2, -1, 0, 1, 2, 3, \dots\}\): Countable.
- \(\mathbb{R}\): Includes all rational and irrational numbers, making it uncountable.

### **Differences in meaning between braces, parentheses, and square brackets**

1. **Braces \(\{\}\):**
   - Denote a **set** in mathematics.
   - Example: \(\{1, 2, 3\}\) represents a set with the elements \(1, 2, 3\).

2. **Parentheses \((a, b)\):**
   - Denote an **open interval** in mathematics.
   - Meaning: All real numbers between \(a\) and \(b\), excluding \(a\) and \(b\).
   - Example: \((1, 5)\) includes \(1.1, 2, \pi, 4.999\), but **not** \(1\) or \(5\).

3. **Square Brackets \([a, b]\):**
   - Denote a **closed interval**.
   - Meaning: All real numbers between \(a\) and \(b\), including \(a\) and \(b\).
   - Example: \([1, 5]\) includes \(1, 3, 4.5, 5\).

4. **Mixed Brackets \((a, b]\) or \([a, b)\):**
   - Denote **half-open intervals**.
   - \((a, b]\): Excludes \(a\), includes \(b\).
   - \([a, b)\): Includes \(a\), excludes \(b\).
   - Example: \((1, 5]\) includes \(1.1, 3, 5\) but excludes \(1\).

### **Other meanings for brackets in reverse direction \([a, b[\):**
In some regions (e.g., Europe), the notation \([a, b[\) or \(\;]a, b]\) is used instead of the more common mixed brackets:
- \([a, b[\) means \([a, b)\) (closed at \(a\), open at \(b\)).
- \(\;]a, b]\) means \((a, b]\) (open at \(a\), closed at \(b\)).

These reversed directions are stylistic preferences and do not change the mathematical meaning.
-----------

So the word *open* from **open interval** just means excluding the 2 numbers which show where the interval starts and ends? 
I doesn't mean the numbers from surrounding intervals can join the interval  in question?
I find the words `open` and `closed` in relation to intervals to be confusing.

You're absolutely right that the terms **"open"** and **"closed"** in the context of intervals can be a bit unintuitive. Let me clarify:

### **Open Interval**
- **Definition**: An open interval \((a, b)\) includes all the numbers **strictly between** \(a\) and \(b\), but **excludes** \(a\) and \(b\).
- The word *open* here means that the interval does **not include its endpoints**. Think of it as leaving "gaps" at \(a\) and \(b\).
- Example: \((1, 5)\) includes \(1.1, 2, 3.5, 4.999\), but **not** \(1\) or \(5\).

### **Closed Interval**
- **Definition**: A closed interval \([a, b]\) includes all the numbers between \(a\) and \(b\), **including** \(a\) and \(b\).
- The word *closed* means the interval **contains its endpoints**—there are no gaps.
- Example: \([1, 5]\) includes \(1, 2, 3, 5\).

### **Does "open" mean numbers from outside the interval can join?**
No, "open" does **not** mean that numbers outside the interval (from surrounding intervals) can "join" the interval. The term *open* only specifies that the **endpoints are excluded**. The set of numbers in \((a, b)\) is still completely distinct from numbers in, say, \((b, c)\).

### **Why are these terms used?**
The words "open" and "closed" come from a broader concept in mathematics called **topology**, where "open" sets are like intervals without boundaries and "closed" sets include their boundaries. It's just terminology that describes the behavior of endpoints.

### **Visual Analogy**
Think of intervals as doors:
1. **Open Interval (\(a, b\))**: The doors at \(a\) and \(b\) are **open**—you can't step on them, but you can walk inside the room.
2. **Closed Interval (\([a, b]\))**: The doors at \(a\) and \(b\) are **closed**—you can step on them, and they are part of the room.

### **Half-Open Intervals**
- A mix of open and closed:
  - \([a, b)\): Includes \(a\) but excludes \(b\).
  - \((a, b]\): Excludes \(a\) but includes \(b\).
- Think of one door being open and the other closed.

### **To Sum It Up**
- *Open* means **endpoints excluded**.
- *Closed* means **endpoints included**.
- This has no effect on numbers outside the interval—they are never part of the interval in question! 
-------
**Question:**

So braces `{}` are for countable sets while parenthesis `()` and square brackets `[]` are for uncountables sets?

**Response:**

Not exactly! Braces `{}`, parentheses `()`, and square brackets `[]` are used differently in set theory and mathematics. Their usage is **not directly tied to whether a set is countable or uncountable**, but rather to the **type of mathematical object** or **interval** being described. Let’s break it down:

---

### **Braces `{}`**
- **Purpose**: Braces `{}` are used to explicitly define **sets**.
- **Examples**:
  - \(\{1, 2, 3\}\): A **finite set** (countable).
  - \(\{n \in \mathbb{N} \mid n \text{ is even}\}\): A **description** of a set (even natural numbers, countable).
  - Braces can also define **uncountable sets** indirectly:
    - \(\{x \in \mathbb{R} \mid x^2 = 2\}\): This is a **set of solutions** for \(x^2 = 2\), which includes \(\{-\sqrt{2}, \sqrt{2}\}\), and it’s finite.
  - You can't **explicitly list** uncountable sets (like real numbers), but you can describe them with set notation.

---

### **Parentheses `()`**
- **Purpose**: Used to denote **open intervals** (not sets directly).
- **Examples**:
  - \((a, b)\): Describes an **open interval** of real numbers \(\{x \in \mathbb{R} \mid a < x < b\}\). This is typically **uncountable** if \(a, b \in \mathbb{R}\).
  - Open intervals exclude the endpoints \(a\) and \(b\).
  - Parentheses can describe both **countable** and **uncountable** sets:
    - **Countable**: \((n, n+1)\), where \(n \in \mathbb{Z}\), could describe an interval for integers.
    - **Uncountable**: \((0, 1)\) contains all real numbers between \(0\) and \(1\) (uncountable).

---

### **Square Brackets `[]`**
- **Purpose**: Used to denote **closed intervals** (not sets directly).
- **Examples**:
  - \([a, b]\): Describes a **closed interval** of real numbers \(\{x \in \mathbb{R} \mid a \leq x \leq b\}\). This is typically **uncountable** if \(a, b \in \mathbb{R}\).
  - Closed intervals include the endpoints \(a\) and \(b\).
  - Similar to parentheses, square brackets can describe **countable** or **uncountable** sets.

---

### **Key Difference Between Braces and Parentheses/Brackets**
- **Braces `{}`**: Used for explicit **sets** or their descriptions.
  - Sets can be **countable** or **uncountable**.
- **Parentheses `()`** and **Brackets `[]`**: Used for **intervals**, typically in the **real numbers** (\(\mathbb{R}\)).
  - Intervals are usually **uncountable** because they describe ranges of real numbers, but they can also represent **countable** subsets in special cases.

---

### **Does This Mean Countability Depends on the Symbol?**
No. Countability is a property of the set itself, not the symbol:
1. A **countable set** like \(\{1, 2, 3\}\) uses braces because we explicitly list its elements.
2. An **uncountable set** like \((0, 1)\) uses parentheses to describe an interval of real numbers, which cannot be explicitly listed.


-------

**Question:**

Why are the set of Natural numbers and the set of Integers said to be countable? 
Let's take the set of Natural numbers for example. We can't list all of it's members because it starts from 1 all the way to positive infinity. It's never ending. There are an infinite number of elements in that set.
So why are those two sets said to be countable?

**Response:**

This is an excellent question! It might seem contradictory to call infinite sets like the set of natural numbers \(\mathbb{N}\) or integers \(\mathbb{Z}\) "countable," but the term "countable" has a specific **mathematical definition**. Let’s break it down:

---

### **Definition of Countable Sets**
A set is **countable** if:
1. It is **finite**, or
2. It is **infinite** but can be placed in a **one-to-one correspondence** (bijection) with the natural numbers (\(\mathbb{N}\)).

This means that the elements of the set can be "counted" (even if they are infinite) by systematically listing them one by one without skipping any.

---

### **Why Are the Natural Numbers Countable?**
The natural numbers themselves (\(\mathbb{N} = \{1, 2, 3, \dots\}\)) are the "baseline" for countability because:
- Each element in \(\mathbb{N}\) is assigned a unique position or index: \(1\) is first, \(2\) is second, \(3\) is third, and so on.
- Although there are infinitely many natural numbers, you can still list them in order: \(1, 2, 3, 4, 5, \dots\).

This ability to "list" all elements of \(\mathbb{N}\), in a sequence where each number corresponds to exactly one "step," is what makes it **countable**.

---

### **Why Are the Integers Countable?**
The integers \(\mathbb{Z} = \{\dots, -3, -2, -1, 0, 1, 2, 3, \dots\}\) are also infinite, but we can show they are countable by creating a **bijection** (one-to-one mapping) with \(\mathbb{N}\). Here's how:

1. Pair each integer with a unique natural number:
   - Start with \(0\), then alternate between positive and negative integers:
     - \(0 \to 1\)
     - \(1 \to 2\), \(-1 \to 3\)
     - \(2 \to 4\), \(-2 \to 5\)
     - \(3 \to 6\), \(-3 \to 7\), and so on.
2. The sequence looks like this:
   \[
   0, 1, -1, 2, -2, 3, -3, \dots
   \]
3. Every integer is assigned to exactly one natural number, and every natural number is assigned to exactly one integer.

Thus, the integers are also **countable**.

---

### **Countable vs. Uncountable**
- **Countable** sets include:
  - Finite sets (\(\{1, 2, 3\}\)).
  - Infinite sets that can be "listed," like \(\mathbb{N}\), \(\mathbb{Z}\), and \(\mathbb{Q}\) (rational numbers).
- **Uncountable** sets include:
  - Sets that **cannot** be placed in one-to-one correspondence with \(\mathbb{N}\), such as the real numbers \(\mathbb{R}\).
  - For example, the interval \((0, 1)\) is uncountable because it contains infinitely many numbers, and you can’t list them all without missing some (this is proven by Cantor's diagonal argument).

---

### **Infinite but Countable**
The key is that "countable" doesn’t mean "finite." Instead, it means there’s a way to systematically enumerate the elements, even if there are infinitely many.

Does this explanation make sense now? 😊






## Side Quests
#### Continuum Math
Many areas of Mathematics, such as algebra or calculus, focus on `Continuums`. These are mathematical objects that take values over continuous ranges, such as the set of numbers *x* between 0 and 1, or mathematical functions plotted as smooth curves.
These objects come with their own class of mathematical methods, but are mostly distinct from the methods for discrete problems.

#### Number Theory
The study of counting numbers (Numbers that are used to count stuff)

#### Cryptography
The art and science of converting data and information into encoded forms that can be ideally **ONLY** be decoded by authorized entities.

This field makes heavy use of:
- Number theory
- Algorithms on base-n number systems 

#### Graph Theory
- used in Logistics
- airlines use it too

#### Set Theory
A relational database makes use of the concept of set theory in order to group together relevant information.
- Chapter 8: Storage and Feature Extraction of Trees, Graphs, and Networks.

#### Machine Learning
This is the area that seeks to automate statistical and analytical methods so systems can find useful patterns in data, learn, and make decisions with minimal human intervention.

#### Analysis of Algorithms
**Algorithm**: *Any set of instructions to accomplish a task*

An effective algorithm must:
1. solve the problem
2. terminate in a useful amount of time (i.e.: not take too much time to terminate)
3. not take up too much space

To ensure the 2nd condition: `terminate in a useful amount of time`, it is often necessary to:
- `count the number of operations` an algorithm must complete in order to terminate

which can be complex, but can be done through `methods of combinatorics`

The 3rd condition requires a similar counting of memory usage.

To continue learning Algorithm Analysis, check:
- Chapter 4 - Combinatorics using SciPy
- Chapter 6 - Computational Algorithms in Linear Algebra
- Chapter 7 - Computational Requirements for Algorithms

## Terms
### **Combinatorics**
- **Definition**: A branch of mathematics that studies finite or discrete structures. It deals with counting, arrangement, and combination of elements in sets according to specified rules.
- **Applications**: Widely used in computer science (e.g., algorithms, complexity, cryptography), statistics, and optimization problems.
- **Etymology**: Derived from the **Latin** word *combinare* ("to combine") and the **Greek** suffix *-ics*, meaning "study of."
  
### **Combinatronics**
- **Definition**: Not a recognized mathematical field. It may be a typo or a playful/invented term. Occasionally, it is used informally in some contexts to refer to computational applications of combinatorics, though this usage is rare.
- **Etymology**: Likely a blend or misunderstanding of "combinatorics" and "electronics" or "mechanics."

If you encountered "combinatronics" in a specific context, it might have a niche meaning—feel free to share more details for clarification!