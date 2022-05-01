Java and C++ Comparisons

### Comprehensive comparison between Java and C++

*   Similarities
    *   Overall similarities
        1.  Their grammars/syntax are very similar. In many cases, C++ has a more neat/simpler/compact format, besides the regular one identical to Java.
        2.  Both are object-oriented languages
        3.  Both use identical comments.
        4.  Both use compiler to convert source codes into object codes, with Java having an additional step for interpreting the .class byte codes using Java Virtual Machine.
    *   Detailed similarities
        1.  **main** function is the entry point for both languages, meaning execution starts from the **main** function.
        2.  Primitive data types: integer, floatpoint, char, boolean.
        3.  Variable definitions and initializations
            *   Java: int x; int y\[\]=new int\[10\]; int \[\]z={3,1,7,10,6};
            *   C++: int x; int y\[10\]; int z\[5\]={3,1,7,10,6};
                *   even simply like: int x,y\[10\],z\[5\]={3,1,7,10,6};
        4.  Expression: arithmetic operators, relational operators, logical operators/conditional operators
            *   Java: a+b>c && b+c>a && a+c>b
            *   C++ (same): a+b>c && b+c>a && a+c>b
        5.  Assignments
            *   Java: x=10; y\[1\]=10; z\[0\]=10;
            *   C++: x=10; y\[1\]=10;z\[0\]=10; or simply, x=10,y\[1\]=10,z\[0\]=10;
                *   even simply like: x=y\[1\]=z\[0\]=10;
        6.  Conditional statements: if-then, if-then-else, switch
            *   Java: if (a+b>c && b+c>a && a+c>b) System.out.println( a +","+ b +","+ c +" can form a trangle");
            *   C++: if (a+b>c && b+c>a && a+c>b) cout<< a <<","<< b <<","<< c <<" can form a trangle";
            *   Java: if (a+b>c && b+c>a && a+c>b) System.out.println( a +","+ b +","+ c +" can form a trangle"); else System.out.printf("%d,%d,%d cannot form a trangle!\\n",a,b,c);
            *   C++: if (a+b>c && b+c>a && a+c>b) cout<< a<<","<< b<<","<< c<<" can form a trangle<< endl; else printf("%d,%d,%d cannot form a trangle!\\n",a,b,c);
        7.  Switch statement
            *   In Java: switch(grade) { case 'A' : System.out.println("Excellent!"); break; case 'B' : case 'C' : System.out.println("Well done"); break; case 'D' : System.out.println("You passed"); case 'F' : System.out.println("Better try again"); break; default : System.out.println("Invalid grade"); }
            *   In C++: switch(grade) { case 'A' : cout<<"Excellent!" << endl; break; case 'B' : case 'C' : cout<<"Well done" << endl; break; case 'D' : cout<<"You passed" << endl; case 'F' : cout<<"Better try again" << endl; break; default : cout<<"Invalid grade" << endl; }
        8.  Loop statements: for/enhanced for, while, do-while
            *   Java and C++, all are same:
            *   int sum=0; for (int i=1;i<=10;i++) sum+=i;
            *   int sum=0; int a\[\]={4,1,7,9.3}; for (int v:a) sum+=v;
            *   int sum=0; int i=10; while (i>0) sum+=i--;
                *   In C++, non-zero is true, so: while(i) sum+=i--;
            *   int sum=0; int i=0; do i++; sum+=i; while (i<10);
        9.  break and continue statement
        10.  classes,
*   Differences
    1.  **main** method/function
        *   In Java, **main** is a static method with a class which will be excuted directly.
        *   In C++, **main** function must be declared as a non-member function in the global namespace. This means that it cannot be a static or non-static member function of a class, nor can it be placed in a namespace (even the unnamed namespace).
    2.  Global variables/functions
        *   In Java, all variables and methods must be defined within a class. That is, they are all a member of a class.
        *   In C++, variables and functions can be defined outside any classes. They are global variables /functions.
    3.  In C++, not zero is also taken as true and zero is false.
    4.  Pointers: C++ can declare/define a pointer variable. In Java, no clear pointer and pointer variable definition.
        *   In Java, all variables defined as arrays and class objects are implicitly pointers.
        *   In C++, all variables for class objects can be considered as pointers too.
    5.  Arrays [C++ vs. Java](https://icarus.cs.weber.edu/~dab/cs1410/textbook/7.Arrays/cpp_v_java.html)
        *   In Java, array variables are implicit pointers and arrays are created as objects. .length is an attribute of the object and gives the size of an array.
        *   In C++, array variables are not pointers, and they can be considered as primitive data type. To get the size of an array, use sizeof(arr)/sizeof(arr\[0\]).
    6.  Dynamic array
        *   In C++: vector, **e.g.**, vector grades; grades.push\_back(10);
        *   In Java, ArrayList, **e.g.**, ArrayList<Integer> grades=new ArrayList(); grades.add(10);
    7.  string
        *   In C++; string is equivalent to char array and a string is mutuable.
        *   In Java, String is a class or is treated as an object and it is immutuable.
    8.  Input/output
        *   In C++: **standard input**: int age; cin >> age; **standard output**: cout << age << endl;
        *   In Java, **input by Scanner**: int age; Scanner scan=new Scanner(System.in); age=scan.nextInt(); **standard output**: System.out.println(age);
        *   Howewver, the formated output printf("....",...) is similar in both Java and C++.
    9.  In C++, pair structure **e.g.**, pair< string, int> nameAge; nameAge.first="Xukai"; nameAge.second=56;
        *   In Java, there is no direct correspondence to pair in C++. To implement it, need to create a class: class pair{String first; int second; public pair(String n,int a){first=n;second=a;}} pair nameAge=new pair("Xukai",56); Normally, there is also a need to override the compareTo method.
        *   A good example of using pair in C++ and creating a new class in Java is [USACO Deceober 2021 Silver P1 problem's C++ and Java solutions](http://www.usaco.org/current/data/sol_prob1_silver_dec21.html).
    10.  In C++, struct structure. struct is a composite data type composing of multiple fields of (different) types.
         *   **e.g.,** struct person{string name; int age; int grade} person teacher; teacher.name="xukai"; teacher.age=56; teacher.grade=18;
         *   In Java, there is no correspondance to it. To implement it, need to create a class. **e.g.,** class person{String name; int age; int grade; public person(String n, int a, int g){name=n; age=a;grade=g;}} person teacher=new person("Xukai",56,18); Normally, there is also a need to override the compareTo method.
         *   In C++, there is another construct similar to struct, i.e., tuple. At this time, you can treat that same, except that tuple can be used directly without naming it in advance.
    11.  In C++, there is an interesting keyword auto. auto meams type inference or type deduction.
         *   That is: Deduces the type of a declared variable from its initialization expression.
         *   It has many benefits besides convenience and simplicity.
         *   The auto keyword is a simple way to declare a variable that has a complicated type. For example, you can use auto to declare a variable where the initialization expression involves templates, pointers to functions, or pointers to members, even a lambda expression.
*   Other discussions and examples
    *   [Java and C++ typical Library Classes](Java-CPlus-DS-In-Library.pptx): Set: HashSet, TreeSet, Map: Hashtable, HashMap, TreeMap, Stack, String
    *   [Comparison of Java/C++/Python -- Program Structure and input/output](ThreeHL-comparison-ProgStructure-IO.pptx)
    *   [Comparison of Java and C++: pair, tuple, and Java hashcode() method](pairTuple.pptx)
        *   [C++ pair & tuple](pairTuple.cpp)
        *   [newly written corresponding Java pair class](JavaPairClass.java)
    *   [Pointers, (dynamic) Array, Iterator in C++/Java a>](pointerVectorIterator.pptx)
        [](pointerVectorIterator.pptx)[C++ test code 1: pointer, array, string](CPlusPointerArrayString.cpp)*   [C++ test code 2: pointer, vector, iterator](CPlusArrayPointerVectorIterator.cpp)
        *   [Java vs C++ codes returning an array](ReturningArrayinJavaAndCPlus.cpp)
    *   [Java, C/C++, and Python comparison -- Abstract classes/Interfaces](ThreeHL-comparison-CPlus-Java-Python.pptx)
*   Online Related Links
    *   [Java-C++ comparision](http://www.math-cs.gordon.edu/courses/cps212/paperwork/Java-C++comparison.pdf)
    *   [Java and C++ similarities](https://www.google.com/amp/s/www.geeksforgeeks.org/similarities-between-java-and-c/amp/)
    *   [C++: STL map, sets,iterator](7-STL-map-set-iterator.pptx)
    *   [C++ online IDE](https://replit.com/languages/cpp)