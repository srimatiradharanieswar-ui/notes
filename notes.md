

# 🌈 **Managing Input and Output (I/O) Console in C++**

C++ provides a powerful set of input and output (I/O) operations.
It uses the **concept of streams** and **stream classes** to manage data with the console and files.

## 🎯 **C++ Streams**

The I/O system gives an interface for handling data.
This interface is called a **stream**.

A **stream** is a flow (sequence) of bytes.

* The stream that **sends data to the program** is called the **input stream**.
* The stream that **receives data from the program** is called the **output stream**.

---

## 🧩 **C++ Stream Classes**

The **C++ I/O system** has a set of classes that define different types of streams for console and file operations.
These are known as **stream classes** and are declared in the **header file `<iostream>`**.

The class **ios** provides the base features for formatted and unformatted I/O.
The class **istream** is used for input, and **ostream** is used for output.
The class **iostream** handles both input and output.

Three additional classes add assignment operators:

* **istream_withassign**
* **ostream_withassign**
* **iostream_withassign**

---

## 🔶 **Text Flowchart: Structure of C++ I/O Stream Classes**

```
                     ┌────────────┐
                     │    ios     │
                     │ (Base I/O) │
                     └─────┬──────┘
                           │
        ┌──────────────────┼──────────────────┐
        │                  │                  │
 ┌─────────────┐     ┌─────────────┐     ┌─────────────┐
 │   istream   │     │   ostream   │     │  streambuf  │
 └─────┬───────┘     └─────┬───────┘     └─────────────┘
       │                   │
┌──────────────┐     ┌──────────────┐
│istream_with  │     │ostream_with  │
│   assign     │     │   assign     │
└──────────────┘     └──────────────┘
       │                    │
       └───────────┬────────┘
                   │
             ┌─────────────┐
             │  iostream   │
             └─────┬───────┘
            ┌──────────────┐
            │iostream_with │
            │   assign     │
            └──────────────┘
```

---

## ⚙️ **Stream Classes for Console Operations**

| **Class Name**                     | **Contents / Description**                                                                                                                                                                      |
| ---------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **ios (General I/O class)**        | - Contains basic features used by all input and output classes.<br>- Has a pointer to a buffer object (**streambuf**).<br>- Declares constants and functions for formatted and unformatted I/O. |
| **istream (Input stream)**         | - Inherits properties from **ios**.<br>- Declares input functions such as **get()**, **getline()**, and **read()**.<br>- Has the overloaded **extraction operator (>>)**.                       |
| **ostream (Output stream)**        | - Inherits properties from **ios**.<br>- Declares output functions like **put()** and **write()**.<br>- Has the overloaded **insertion operator (<<)**.                                         |
| **iostream (Input/Output stream)** | - Inherits properties from **ios**, **istream**, and **ostream** through multiple inheritance.<br>- Contains both input and output functions.                                                   |
| **streambuf**                      | - Connects streams to physical devices through buffers.<br>- Acts as a base for **filebuf** used by I/O files.                                                                                  |

---

## ✴️ **Unformatted I/O Operations**

Unformatted I/O includes:

* Overloaded operators **>>** and **<<**
* **put()** and **get()** functions
* **getline()** and **write()** functions

---

### 🟢 **Overloaded Operators >> and <<**

C++ uses **cin** and **cout** for data input and output.
These use the overloaded **>>** and **<<** operators.

* **>>** is overloaded in the **istream** class.
* **<<** is overloaded in the **ostream** class.

#### 📥 Input Example

```cpp
cin >> variable1 >> variable2 >> ... >> variableN;
```

Data must be separated by spaces and should match the variable types.
The reading stops when a whitespace or an invalid character is found.

Example:

```cpp
int code;
cin >> 4258D;
```

The program reads `4258` and assigns it to `code`, stopping before `D`.

#### 📤 Output Example

```cpp
cout << item1 << item2 << ... << itemN;
```

Items can be constants or variables of any type.

---

### 🟣 **put() and get() Functions**

The **istream** and **ostream** classes have two functions for single-character I/O:

* `get(char*)` → reads a character and stores it in its argument.
* `get(void)` → returns the character read.
* `put()` → outputs a single character.

Examples:

```cpp
cout.put('x');    // Displays: x
cout.put(ch);     // Displays the value of variable ch
cout.put(68);     // Displays: D (ASCII 68 = D)
```

---

### 🔵 **getline() and write() Functions**

**getline()** reads an entire line (until a newline character).

```cpp
cin.getline(line, size);
```

* Reads characters into `line`.
* Stops when a newline is read or when `size - 1` characters are read.

**write()** displays a line of text.

```cpp
cout.write(line, size);
```

* `line` → string name.
* `size` → number of characters to display.

---

## 🧮 **Formatted I/O Operations**

C++ provides special tools to control how data is displayed.

These include:

* **ios class functions and flags**
* **Manipulators**

---

### 🔹 **ios Class Functions and Flags**

| **Function**    | **Task**                                           |
| --------------- | -------------------------------------------------- |
| **width()**     | Sets the width of the output field.                |
| **precision()** | Sets the number of digits after the decimal point. |
| **fill()**      | Sets the character used to fill empty spaces.      |
| **setf()**      | Sets formatting flags to control display.          |
| **unsetf()**    | Clears specific formatting flags.                  |

---

# Defining Field Width — `width()`

The `width()` function sets how wide the field must be when printing an item.

```cpp
cout.width(w);
```

* `w` is the field width. The output is printed right-justified in a field `w` characters wide.
* Example:

```cpp
cout.width(5);
cout << 543;   // Output: (two leading spaces)543
cout.width(5);
cout << 12;    // Output continues after previous: (two leading spaces)543(three leading spaces)12
```

(Above, each pair of leading spaces shows unused positions created by the field width.)

---

# Setting Precision — `precision()`

You can control how many digits show after the decimal point for floating-point numbers.

```cpp
cout.precision(d);
```

* `d` is the number of digits shown after the decimal.
* Example:

```cpp
cout.precision(3);
cout << sqrt(2) << "\n"; // Output: 1.414
cout << 3.14159;         // Output: 3.142
```

---

# Filling and Padding — `fill()`

When a field is wider than the printed value, `fill()` chooses which character fills the empty space.

```cpp
cout.fill(ch);
```

* `ch` is the character used to fill unused positions.
* Example:

```cpp
cout.fill('*');
cout.width(10);
cout << 5250;   // Output: ******5250
```

---

# Formatting Flags, Bit-fields and `setf()`

Use `setf()` to control many formatting options. It can take one or two arguments:

```cpp
cout.setf(arg1, arg2);
```

* `arg1` is a formatting flag (what you want).
* `arg2` is the bit-field (the group the flag belongs to).

Example:

```cpp
#include <iostream>
using namespace std;
int main() {
    int num = 15;
    cout.setf(ios::hex, ios::basefield);
    cout << num; // Output: f
    return 0;
}
```

There are three bit-fields (groups), each with related flags. Example flag groups:

| Format required            | Flag (arg1)       | Bit-field (arg2)   |
| -------------------------- | ----------------- | ------------------ |
| Left-justified output      | `ios::left`       | `ios::adjustfield` |
| Right-justified output     | `ios::right`      | `ios::adjustfield` |
| Padding after sign or base | `ios::internal`   | `ios::adjustfield` |
| Scientific notation        | `ios::scientific` | `ios::floatfield`  |
| Fixed point notation       | `ios::fixed`      | `ios::floatfield`  |
| Decimal base               | `ios::dec`        | `ios::basefield`   |
| Octal base                 | `ios::oct`        | `ios::basefield`   |
| Hexadecimal base           | `ios::hex`        | `ios::basefield`   |

Example combining `fill`, `setf`, and `width`:

```cpp
cout.fill('*');
cout.setf(ios::left, ios::adjustfield);
cout.width(15);
cout << "TABLE 1" << "\n";
```

This prints:

```
TABLE 1*******
```

(`"TABLE 1"` appears left-justified and the unused positions are filled with `*`.)

---

# Displaying Trailing Zeros and Plus Sign

Some formatting flags are used alone (they don’t need a bit-field). These change how numbers look:

| Flag             | Meaning                                          |
| ---------------- | ------------------------------------------------ |
| `ios::showbase`  | Show base indicator (for example, `0x` for hex). |
| `ios::showpos`   | Print `+` before positive numbers.               |
| `ios::showpoint` | Show decimal point and trailing zeros.           |
| `ios::uppercase` | Use uppercase letters for hex output.            |
| `ios::skipws`    | Skip whitespace on input.                        |
| `ios::unitbuf`   | Flush all streams after each insertion.          |
| `ios::stdio`     | Flush `stdout` and `stderr` after insertion.     |

---

# Managing Output with Manipulators

The header `<iomanip>` provides manipulators — easy-to-use functions that do the same jobs as `ios` member functions.

* Manipulators can be chained in one `cout` statement:

```cpp
cout << manip1 << manip2 << manip3 << item;
```

* Or you can apply a manipulator, print an item, then apply another manipulator:

```cpp
cout << manip1 << item1 << manip2 << item2;
```

Common manipulators and their equivalents:

| Manipulator             | Meaning                             | Equivalent `ios` function |
| ----------------------- | ----------------------------------- | ------------------------- |
| `setw(int w)`           | Set the field width to `w`          | `width()`                 |
| `setprecision(int d)`   | Set floating-point precision to `d` | `precision()`             |
| `setfill(int c)`        | Set fill character to `c`           | `fill()`                  |
| `setiosflags(long f)`   | Set format flag `f`                 | `setf()`                  |
| `resetiosflags(long f)` | Clear the format flag `f`           | `unsetf()`                |
| `endl`                  | Insert newline and flush the stream | `"\n"` + flush            |

Examples:

```cpp
cout << setw(10) << 12345;

cout << setw(10) << setprecision(4) << sqrt(2);

cout << endl;
```

---

# Summary

* A **stream** is a sequence of bytes that acts as a source (input) or destination (output) for data.
* The **input stream** supplies data to the program; the **output stream** receives data from the program.
* `get()` and `put()` handle single-character I/O.
* The `>>` operator (extraction) and `<<` operator (insertion) are overloaded for `istream` and `ostream`, respectively.
* `width()`, `precision()`, `fill()`, and `setf()` are `ios` functions used to format output.
* `<iomanip>` provides manipulators that make formatting convenient and readable.

---

# Short Answer — (Questions & Answers)

**Q1. Discuss the various forms of `get()` functions supported by the input stream. How are they used?**

* There are two types of `get()` functions: `get(char*)` and `get(void)`.

  * `get(char*)` assigns the input character to the argument you pass.
  * `get(void)` reads and returns the next input character.

**Q2. How do the following two statements differ in operation?**

```cpp
cin >> c;
cin.get(c);
```

* `cin >> c;` uses the extraction operator: it skips whitespace and newlines before reading a character.
* `cin.get(c);` reads the next character exactly as it is — it includes spaces, tabs, and newline characters.

**Q3. What does the following statement do?**

```cpp
cout.write(s1, m).write(s2, n);
```

* It writes the first `m` characters from `s1` to the output, and then writes the first `n` characters from `s2` to the output.

**Q4. What is the difference between `put()` and `write()`?**

* `put()` outputs a single character at a time.
* `write()` outputs a block or whole line of characters (a string of known length).

**Q5. What will be the output of the following statements?**

```cpp
cout.setf(ios::showpoint);
cout.setf(ios::showpos);
cout.precision(3);
cout.setf(ios::fixed, ios::floatfield);
cout.setf(ios::internal, ios::adjustfield);
cout.width(10);
cout << 275.5 << "\n";
```

**Output (with spaces shown as underscores for clarity):**

```
+__275.500
```

(That is a `+`, then two spaces, then `275.500` — the `precision(3)` gives three digits after the decimal, `showpos` adds `+`, and `internal` places padding between sign and number.)

**Q6. What is the basic difference between manipulators and `ios` member functions in implementation? Give examples.**

* Manipulators are more convenient and readable than calling `ios` member functions directly.
* Example:

```cpp
cout << setw(10) << setprecision(3) << value;
```

is easier and cleaner than repeatedly calling `cout.width()`, `cout.precision()`, etc.

