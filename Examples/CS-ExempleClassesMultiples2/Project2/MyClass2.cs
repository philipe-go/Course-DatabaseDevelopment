using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Project1;  // to access MyClass1 we need this using statement AND to "add reference".

namespace Project2
{
    class MyClass2 : MyClass1
    {
        internal string myF3()
        {
            return "I'm myF3() from MyClass2 and myF1() returns: " + this.myF1();
        }

        internal string myF4()
        {
            return "I'm myF4() from MyClass2 and myF2() is not visible from MyClass2"; // this.myF2();
        }
    }
}
