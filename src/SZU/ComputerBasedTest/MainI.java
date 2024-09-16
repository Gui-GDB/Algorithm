package SZU.ComputerBasedTest;/*
题目描述
    Trie树又称单词查找树，是一种树形结构，如下图所示。
    它是一种哈希树的变种。典型应用是用于统计，排序和保存大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。
    它的优点是：利用字符串的公共前缀来节约存储空间，最大限度地减少无谓的字符串比较，查询效率比哈希表高。
    输入的一组单词，创建Trie树。输入字符串，计算以该字符串为公共前缀的单词数。
    （提示：树结点有26个指针，指向单词的下一字母结点。）
输入
    测试数据有多组
    每组测试数据格式为：
    第一行：一行单词，单词全小写字母，且单词不会重复，单词的长度不超过10，用于构建Trie树
    第二行：测试次数t
    后跟t行，每行一个字符串
输出
    每组测试数据输出格式为：
    第一行：创建的Trie树的层次遍历结果
    第2~t+1行：对每行字符串，输出树中以该字符串为公共前缀的单词数。
输入样例1
    abcd abd bcd efg hin
    3
    ab
    bc
    abcde

输出样例1
    abehbcficddgnd
    2
    1
    0

 */
//todo 机考的时候只通过了一个测试样例
import java.util.*;

public class MainI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] words = s.split(" ");
        int n = sc.nextInt();

        StringBuilder sb = getStringBuilder(words);
        System.out.println(sb);

        for (int i = 0; i < n; i++) {
            String word = sc.next();
            int res = 0;
            for (String string : words) {
                if (string.length() < word.length())
                    continue;
                if (string.startsWith(word))
                    res++;
            }
            System.out.println(res);
        }
    }

    private static StringBuilder getStringBuilder(String[] words) {
        int max_length = 0;

        for (String word : words) {
            max_length = Math.max(max_length, word.length());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= max_length; i++) {
            Set<String> set = new HashSet<>();
            ArrayList<Character> temp = new ArrayList<>();
            for (String word : words) {
                if (word.length() < i)
                    continue;
                if (!set.contains(word.substring(0, i))) {
                    temp.add(word.charAt(i - 1));
                    set.add(word.substring(0, i));
                }
            }
            Object[] array = temp.toArray();
            Arrays.sort(array);
            for (Object object : array) {
                sb.append(object);
            }
        }
        return sb;
    }
}