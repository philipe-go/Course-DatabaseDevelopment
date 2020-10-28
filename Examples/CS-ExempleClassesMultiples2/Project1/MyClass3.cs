using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Project1
{
    class MyClass3 : MyClass1
    {
        internal string myF5()
        {
            return "I'm myF5() from MyClass3 and myF1() returns: " + this.myF1();
        }

        internal string myF6()
        {
            return "I'm myF6() from MyClass3 and myF2() returns: " + this.myF2();
        }
    }
}
