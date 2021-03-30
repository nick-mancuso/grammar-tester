# grammar-tester
Simple parser to compare two grammar's parsing ability and performance on a given directory of Java files.

## RESULTS

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
```
