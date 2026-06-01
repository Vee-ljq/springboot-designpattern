package cn.ljq.springboot.interpreterPattern21;


/**
 * 解释器模式(使用率最低，因为需要自己定义语言规则时适用)
 * 适用：语法规则简单
 * 缺点：节点很多时，迭代有成本
 *
 * eg     定义句子语法：主语   +   谓语   +  宾语
 *                   / \        |        / \
 *                 代词 名词     动词     代词 名词                     非终端表达式
 *                 我  麻雀/小张  是      他   动物                    终端符表达式
 *
 *
 */
public class InterpreterTest {
    public static void main(String[] args) {
        Interpreter a = new NumberInterpreter(100);
        Interpreter b = new NumberInterpreter(200);
        AddInterpreter add = new AddInterpreter(a, b);
        System.out.println("加法解释器的结果："+add.interpret());
    }
}

//解释器
interface Interpreter {
    int interpret();
}

//终结符表达式
class NumberInterpreter implements Interpreter {
    private int num;

    public NumberInterpreter(int num) {
        this.num = num;
    }

    @Override
    public int interpret() {
        return this.num;
    }
}

//非终结符表达式
class AddInterpreter implements Interpreter {
    private Interpreter a;
    private Interpreter b;

    public AddInterpreter(Interpreter a, Interpreter b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int interpret() {
        return this.a.interpret() + this.b.interpret();
    }
}