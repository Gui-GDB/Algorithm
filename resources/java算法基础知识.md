## Java 变量的初始化规则总结：

1. **局部变量**（定义在方法、构造函数或代码块内的变量）：

   - **不会自动初始化**，必须手动赋值后才能使用。
   - **如果在使用前未赋值，编译时会报错。**

   示例：

   ```java
   public void method() {
       int x;  // 局部变量
       System.out.println(x);  // 编译错误，x 未初始化
   }
   ```

2. **成员变量**（类的实例变量，定义在类内、方法外的变量）：

   - 会被**自动初始化**为默认值。
   - 默认值取决于变量的类型：
     - 基本数据类型：`0`（数值型）、`false`（布尔型）、`'\u0000'`（字符型）。
     - 引用类型：`null`。

   示例：

   ```java
   public class MyClass {
       int x;  // 实例变量，自动初始化为 0
       String str;  // 实例变量，自动初始化为 null
   }
   ```

3. **静态变量**（类的静态字段，使用 `static` 修饰）：

   - 和成员变量类似，**会自动初始化**为默认值。
   - 初始化时机是在类加载时，默认值与成员变量相同。

   示例：

   ```java
   public class MyClass {
       static int x;  // 静态变量，自动初始化为 0
       static String str;  // 静态变量，自动初始化为 null
   }
   ```

4. **数组变量**：

   - 数组本身是引用类型，声明后如果不初始化，数组引用为 `null`。
   - 一旦使用 `new` 创建数组，则**数组的每个元素**都会被自动初始化：
     - 对于基本数据类型的数组，元素会被初始化为相应的默认值（如 `int[]` 的元素为 `0`）。
     - 对于引用类型数组，元素会被初始化为 `null`。
     - 

   示例：

   ```java
   public void method() {
       int[] arr = new int[5];  // 数组元素自动初始化为 0
       System.out.println(arr[0]);  // 输出 0
       Arrays.fill(arr, 42); // 数组所有元素初始化为42
       System.out.println(arr[0]);  // 输出 42
   }
   ```

### 总结：

- **局部变量**：不会自动初始化，必须手动赋值。
- **成员变量**和**静态变量**：会自动初始化为类型的默认值。
- **数组**：数组元素会自动初始化为类型的默认值，但数组引用变量需要手动赋值（用 `new` 关键字）。

------

## 数学问题

### [最大公约数和最小公倍数](https://blog.csdn.net/weixin_51585785/article/details/119492687?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2~default~CTRLIST~Rate-1-119492687-blog-25077167.235^v38^pc_relevant_default_base3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2~default~CTRLIST~Rate-1-119492687-blog-25077167.235^v38^pc_relevant_default_base3&utm_relevant_index=2)

- 一般使用 gcd(a, b) 来表示 a 和 b 的最大公约数，而求解最大公约数常用欧几里得算法（即辗转相除法）。

- 定理：两个整数的最大公约数等于其中较小的数和两数相除**余数**的最大公约数。gcd(a, b) = gcd(b, a%b)。

  - 如果 a<b，那么定理的结果就是将 a 和 b 交换。

  - 如果 a>b，那么通过这个定理总可以将数据规模变小，并且减小得非常快。

  - 0 和任意一个整数 a 的最大公约数都是 a （注意不是0）。

    ```java
    // 计算两个整数的最大公约数
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    // 计算多个整数的最大公约数
    public static int gcdOfArray(int[] arr) {
        int m = arr[0];
        for (int i = 1; i < arr.length; i++) {
            m = gcd(m, arr[i]);
        }
        return m;
    }
    ```

- 一般用 lcm(a, b) 来表示 a 和 b 的最小公倍数。最小公倍数的求解是建立在最大公约数的基础上进行。当得到 a 和 b 的最大公约数 d 之后，可以马上得到最小公倍数为 a*b/d。

- 由于 ab 在实际的计算时有可能溢出，因此更恰当的写法是 （a / b*d）。

### [素数](https://blog.csdn.net/afei__/article/details/80638460)

- 素数又称为质数，是指除了 1 和本身之外，不能被其他数整除的一类数。注意：1既不是素数，也不是合数。

- 如果一个正整数 n ，它存在 1 和本身之外的因子，那么一定是在 sqrt(n) 的左右成对出现。

- 大于等于 5 的质数一定和 6 的倍数相邻。

- 判断一个数是否是素数：判断 n 是否能被 2 ~ n-1中的一个数整除的时间复杂度为 O(n)；如果判断 n 是否能被 2 ~ sqrt(n)（向下取整） 中的一个数整除的时间复杂度为 O(sqrt(n))。

  ```java
  public static boolean isPrime(int n) {
      if (n <= 1)
          return false;
      if (n == 2) // 2 is the only even prime number
          return true;
      if (n % 2 == 0) // Other even numbers are not prime
          return false;
      for (int i = 3; i * i <= n; i += 2) { // Check only odd numbers
          if (n % i == 0)
              return false;
      }
      return true;
  }
  ```

- 获取素数表：**”筛法“**是众多筛法中最简单且容易理解的一种，即 **Eratosthenes** 筛法（时间复杂度为**O(nloglogn）**。欧拉筛法可以达到O(n)。

  - 算法从小到大枚举所有数，对每一个素数，筛去它的所有倍数，剩下的就都是素数了。

  - 当从小到大到达某数 a 时，如果 a 没有被前面的步骤的数筛去，那么 a 一定是素数。这是因为，如果 a 不是素数，那么 a 一定有小于 a 的素因子，这样在之前的步骤中 a 一定会被筛掉，所以当枚举到 a 时还没有被筛掉，那么 a 一定时素数。

    ```java
    public class PrimeSieve  {
        private static final int MAX_N = 1000001;
        private final boolean[] prime = new boolean[MAX_N];
    
        // 获取素数表，如果prime数组中某个元素为false，则说明对应的下标是素数
        public static void findPrime() {
            for (int i = 2; i < MAX_N; i++) {
                if (!prime[i]) { // 如果prime[i]为false，表示i是素数
                    for (int j = i + i; j < MAX_N; j += i) {
                        prime[j] = true; // 将i的倍数标记为true，表示这些数不是素数
                    }
                }
            }
        }
    
        // 判断一个数是否是素数
        public static boolean isPrime(int n) {
            if (n < 2 || n >= MAX_N) return false;
            return !prime[n]; // 如果prime[n]为false，表示n是素数
        }
    }
    ```

### [快速幂](https://zhuanlan.zhihu.com/p/95902286)

- **快速幂**（**Exponentiation by squaring**，平方求幂）是一种简单而有效的小算法，它可以以 O(log n) 的时间复杂度计算乘方。

- **快速幂的扩展**，在算 a 的 n 次方时，只要a的数据类型支持**乘法**且**满足结合律**，快速幂的算法都是有效的。矩阵、高精度整数，都可以照搬这个思路。

  ```java
  public class QuickPower {
  	//计算a的n次方，如果n是偶数（不为0），那么就先计算a的n/2次方，然后平方；如果n是奇数，那么就先计算a的n-1次方，再乘上a；递归出口是a的0次方为1。
      // 计算 a 的 n 次方，使用递归快速幂
      public static int qpow(int a, int n) {
          if (n == 0)
              return 1;
          if (n % 2 == 1)
              return qpow(a, n - 1) * a;
          //注意，这个temp变量是必要的，因为直接写成 qpow(a, n/2)*qpow(a, n/2)，那会计算两次a的n/2次方，整个算法就退化为了O(n)。
          int temp = qpow(a, n / 2); 
          return temp * temp;
      }
  
      // 递归快速幂（对大素数取模），//由于每一个返回值都是对P取模了的，所以每次递归返回的值都是小于P的。
      public static long qpow(long a, long n, long p) {
          if (n == 0)
              return 1;
          if (n % 2 == 1)
              return qpow(a, n - 1, p) * a % p;
          long temp = qpow(a, n / 2, p);
          return temp * temp % p;
      }
  }
  ```

### [质因数分解](https://zhuanlan.zhihu.com/p/415361242)

- 所谓质因数分解是指将一个正整数 n 写成一个或多个质数的乘积的形式。**（首先需要获取到素数表）**

- 对一个正整数 n 来说，如果它存在 [2, n] 范围内的质因子，要么这些质因子全部小于等于 sqrt(n)，要么只存在一个大于 sqrt(n) 的质因子，而其余质因子全部小于等于 sqrt(n)。

- 解题思路一：时间复杂度为：**O(根号n)**

  - 枚举 1~sqrt(n) 范围内的所有质因子 p，判断 p 是否是 n 的因子。

    - 如果 p 是 n 的因子，则 n = n / p，继续重复判断 p 是否是 n 的因子，直到 p 不是 n 的因子。
    - 如果 p 不是 n 的因子，就直接跳过。  

  - 如果上面的步骤结束后 n 仍然大于 1，说明 n 有且仅有一个大于 sqrt(n) 的质因子（有可能是n本身），当前该数就是这个质因子。 

    ```java
    public static List<Integer> primeFactorization(int n) {
        List<Integer> factors = new ArrayList<>();
        // 从 2 开始枚举所有可能的质因子，直到 sqrt(n)
        for (int i = 2; i * i <= n; i++) {
            // 当 i 是 n 的因子时
            while (n % i == 0) {
                factors.add(i); // 将因子 i 添加到列表中
                n /= i; // 将 n 除以 i
            }
        }
        // 如果 n 大于 1，则 n 是最后一个大于 sqrt(n) 的质因子
        if (n > 1)
            factors.add(n);
        return factors; // 返回质因子列表
    }
    ```

- 解题思路二：时间复杂度为：**O(根号n + log2n)**

  ```java
  public static List<Integer> getPrimeFactors(int num) {
      List<Integer> primeFactors = new ArrayList<>();
      // 寻找所有的2因子
      while (num % 2 == 0) {
          primeFactors.add(2);
          num /= 2;
      }
      // 寻找所有的奇数因子
      for (int i = 3; i * i <= num; i += 2) {
          while (num % i == 0) {
              primeFactors.add(i);
              num /= i;
          }
      }
      // 如果剩余的num大于2，则它本身就是一个质因子
      if (num > 2) 
          primeFactors.add(num);
      return primeFactors;
  }
  ```

## [排序算法](https://blog.csdn.net/qq_39181839/article/details/109478094)

### 快速排序

- 采用“分治”的思想，对于一组数据，选择一个基准元素（base），通常选择第一个或最后一个元素，通过第一轮扫描，**比base小的元素都在base左边，比base大的元素都在base右边**，再有同样的方法**递归排序**这两部分，直到序列中所有数据均有序为止。

  ```java
  public static void quickSort(int nums[], int start, int end) {
      //数组有多个元素进行排序
      if (start < end) {
          int base = nums[start];//以要进行排序数组第0个元素为base
          int left = start;//左指针
          int right = end;//右指针
          while (left < right) {
              //从右向左找，比base大，right--
              while (left< right && nums[right] >= base)
                  right--;
              //比base小，替换left所在位置的数字
              nums[left] = nums[right];
              //从左向右找，比base小，left++
              while (left < right && nums[left] <= base)
                  left++;
              //比base大，替换right所在位置的数字
              nums[right] = nums[left];
          }
          nums[left] = base;//此时left=right，用base替换这个位置的数字
          //排列比base小的数字的数组
          quickSort(nums, start, left - 1);
          //排列比base大的数字的数组
          quickSort(nums, left + 1, end);
      }
  }
  ```

* 采用分治的思想，先找到 每次分割的点 pos ，再排序。

  ```java
  /*
      left:数组左边界
      right：数组右边界
      */
      public void quickSort(int[] arr, int left, int right){
          if(left < right){
              int pos = partition(arr, left, right);
              quickSort(arr, left, pos - 1);
              quickSort(arr, pos + 1, right);
          }
      }
      public int partition(int[] arr, int left, int right){
          int base = arr[left];
          while(left < right){
              while(left < right && arr[right] >= base){
                  right--;
              }
              arr[left] = arr[right];
              while(left < right && arr[left] <= base){
                  left++;
              }
              arr[right] = arr[left];       
          }
          arr[left] = base;
          return left;
      }
  }
  ```

## 常用工具类

### Arrays类

```java
// 将arr数组元素变为字符串，一般用于输出看看数组情况，省去遍历的繁琐操作
toString(arr)  		
// arr数组排序，可以传入匿名类Comparator自定义排序方式
sort(arr,new Comparator<T>(){}) 	
// arr数组二分查找(需要排好序)元素ele，返回目标值索引，找不到返回-1			
binarySearch(arr,ele) 	
// 复制arr数组[from,to)位置元素，返回复制好的数组副本
copyOfRange(arr,from,to)
// 使用ele元素将数组填充
fill(arr,ele) 		
// 比较两个数组元素的内容是否完全一致
equals(arr1,arr2) 		
    
// copyOf() 从数组的开头开始复制，可以指定新数组的长度。如果新数组的长度大于原数组的长度，新的元素会用默认值填充。
Arrays.copyOf(dataType[] srcArray,int length);
// copyOfRange：复制指定范围的元素，可以从数组的任意位置开始，并且需要指定起始和结束索引。
Arrays.copyOfRange(dataType[] srcArray,int startIndex,int endIndex)
```

### Collections

```java
// 仅List可用
// 反转List中的元素
reverse(list) 	
// 按照小到大对链表进行排序【默认】，也可以实现Compartor接口自定义排序
sort(list,new Cpmparator<T>(){}) 
// 将list中的i处元素和j处元素进行交换
swap(list,i,j) 
// list2拷贝到list1，要确保list1有足够空间
copy(list1,list2) 	
// 将list中的A替换成B
replaceAll(list,A,B)	
    
// List和Set都可用
// 返回最大、最小元素
max(list)/min(list) 
// ele出现次数
frequency(list,ele) 
```

### Integer

```java
// Boolean，Double等都有类似将字符串转换的方法👇
// 将字符串参数解析为带符号的十进制整数
parseInt(String s) 	
// 将字符串参数解析为第二个参数指定的基数中的有符号正整数
// radix参数不填则默认以十进制数进行解析
parseInt(String s, int radix)  
// 将i转为k进制真值【有正负号】
toString(int i，k) 
```

### Math

```java
// a,b的最值
min(a,b)/max(a,b)
// 返回正确舍入的 double 值的正平方根
sqrt(double a)		
// 绝对值
abs(a)		
// a的b次方，返回一个double类型的数。
pow(double a, double b) 
// 向上取整
ceil(double x)		
// 向下取整
floor(double x)	
// 四舍五入取整
round(double x)	
// 生成一个[0,1)之间的double类型的伪随机数
random()				
// tan，cos与sin类似
// acos(-1)=π
// 正弦值
sin(double a) 
// 反正弦值
asin(double a) 			
```

### 大数类

```java
// 传入字符串参数直接创建，可以使用=进行同类型赋值
BigInteger a = new BigInteger("123456789101112131415");
BigDecimal c = new BigDecimal("123456.123456");
// 以二进制解析"111110"，变为10进制赋值给d
BigInteger d = new BigInteger("111110", 2);	
// 把a转化为16进制的字符串输出
System.out.println(a.toString(16));	

// a对象值+b对象值并将结果返回
a.add(b)
// 减法，同上👆
a.subtract(b) 
// 乘法，同上
a.multiply(b) 
// 除法，同上
a.divide(b)   
// 取余，同上
a.mod(b)
// 最大公因数，同上
a.gcd(b)	
// 最值，同上
a.max(b)/a.min(b)	
// a的b次方
a.pow(b) 
// 比较大小，a大返回1
a.compareTo(b) 
// 把BigInteger 转化为 BigDecimal
toBigDecimal() 
// 把BigDecimal 转化为 BigInteger
toBigInteger() 
    
//BigDecimal在乘除时可以指定结果舍入方式
// 只有乘除法才有舍入这个说法
// 向零舍入。 即1.55 变为 1.5 , -1.55 变为-1.5
ROUND_DOWN 
// 向正无穷舍入. 即 1.55 变为 1.6 , -1.55 变为 -1.5
ROUND_CEILING
// 向负无穷舍入. 即 1.55 变为 1.5 , -1.55 变为 -1.6
ROUND_FLOOR
// 四舍五入 即1.55 变为1.6, -1.55变为-1.6
ROUND_HALF_UP 
// 五舍六入 即 1.55 变为 1.5, -1.5变为-1.5
ROUND_HALF_DOWN 
    
// a除b结果四舍五入并保留两位小数返回给c
BigDecimal c = a.divide(b, 2, BigDecimal.ROUND_HALF_UP);
// a保留两位小数并且向0舍入
a = a.setScale(2, BigDecimal.ROUND_DOWN);
```

# 一些细节

## 保留几位小数的问题
