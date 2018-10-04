## 简单编辑器

## 抽象封装

### 功能函数
- 函数名（命名为功能性，如process等）：作用（比如处理输入输出）
- public String process(String text, int width)：根据输入的text和单行宽度width处理字符串。
- private StringBuilder printSeg()：将segements[]成员转换成字符串。
- private List<Integer> parseInput(char []input) : 将断点以list的形式返回　1112233(2,3是这个字符串的断点)。
- private boolean isChar(char c) : 判断字符是否为英文大小写
- private boolean isWhite(char c) : 判断字符是否为空格符号
- private char[] getChars(int begin, int end, char []obj) : 返回obj字符串begin -end范围内的子串

### 成员
- private class Segment：　内部类，将字符串的一节封装为一个内部类对象。包括每节字符串的内容（value），以及每节的起始位置(begin,end)；

- private Segment[] segments :　用于的存放内部类对象的数组。

## 工具类
### 工具函数
- public static void checkCharacter(String in) throws Exception :检查是否存在非法字符，并抛出对应的异常。
- public static void checkRange(String in) throws Exception : 检查字符串长度是否满足要求，并抛出对应的异常。

## 测试用例
```bash
命令行打开文件夹

javac Solution.java //编译源文件

java Solution//运行

The main theme of education in engineering school is learning
to teach yourself//输入要处理的文本内容

10//输入每行的长度
```


