# grammar-tester
Simple parser to compare an ANTLR4 Java grammar's parsing ability and performance on a given directory of Java files.

## RESULTS


![](https://github.com/nmancus1/grammar-tester/blob/master/parsing_rate.png) 
![](https://github.com/nmancus1/grammar-tester/blob/master/success_parse_perc.png)


Checkstyle test inputs only: https://github.com/nmancus1/grammar-tester/blob/master/checkstyle-test-resources.out

```bash
Total Java 8 grammar execution time: 3081 ms
Number of successfully parsed files: 1132
Number of files failed to parse: 26

Total Java 9 grammar execution time: 76189 ms
Number of successfully parsed files: 1154
Number of files failed to parse: 4


```


Entire Checkstyle repo: https://github.com/nmancus1/grammar-tester/blob/master/full-checkstyle-repo.out

```bash

Total Java 8 grammar execution time: 6592 ms
Number of successfully parsed files: 2568
Number of files failed to parse: 189

Total Java 9 grammar execution time: 417704 ms
Number of successfully parsed files: 2595
Number of files failed to parse: 162

Total Java 8 NO grammar execution time: 396005 ms
Number of successfully parsed files: 3799
Number of files failed to parse: 180
```

Entire PMD repo: https://github.com/nmancus1/grammar-tester/blob/master/full-pmd.out

```bash
Total Java 8 grammar execution time: 9619 ms
Number of successfully parsed files: 3378
Number of files failed to parse: 79

Total Java 9 grammar execution time: 996548 ms
Number of successfully parsed files: 3384
Number of files failed to parse: 73

Total Java 8 NO grammar execution time: 517036 ms
Number of successfully parsed files: 3372
Number of files failed to parse: 85
```

Entire jOOl repo: https://github.com/nmancus1/grammar-tester/blob/master/jOOL.out

```bash
Total Java 8 grammar execution time: 12323 ms
Number of successfully parsed files: 310
Number of files failed to parse: 1

Total Java 9 grammar execution time: 274813 ms
Number of successfully parsed files: 311
Number of files failed to parse: 0

Total Java 8 NO grammar execution time: 187140 ms
Number of successfully parsed files: 310
Number of files failed to parse: 1

```
Entire hibernate-orm repo: https://github.com/nmancus1/grammar-tester/blob/master/hibernate-orm.out

```bash
Total Java 8 grammar execution time: 19104 ms
Number of successfully parsed files: 10298
Number of files failed to parse: 7

Java 9:
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space

Total Java 8 NO grammar execution time: 1877485 ms
Number of successfully parsed files: 10298
Number of files failed to parse: 7
```

Entire protonpack repo: https://github.com/nmancus1/grammar-tester/blob/master/protonpack.out

```bash
Total Java 8 grammar execution time: 2148 ms
Number of successfully parsed files: 61
Number of files failed to parse: 0

Total Java 9 grammar execution time: 35973 ms
Number of successfully parsed files: 61
Number of files failed to parse: 0

Recursively parsing: /home/nick/development/protonpack
Total Java 8 NO grammar execution time: 27099 ms
Number of successfully parsed files: 61
Number of files failed to parse: 0
```

Entire sevntu repo: https://github.com/nmancus1/grammar-tester/blob/master/sevntu.out

```bash
Total Java 8 grammar execution time: 2887 ms
Number of successfully parsed files: 369
Number of files failed to parse: 0

Total Java 9 grammar execution time: 90874 ms
Number of successfully parsed files: 367
Number of files failed to parse: 2

Total Java 8 NO grammar execution time: 67061 ms
Number of successfully parsed files: 367
Number of files failed to parse: 2
```
