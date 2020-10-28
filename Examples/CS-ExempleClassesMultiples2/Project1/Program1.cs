using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Project1
{
    class Program1
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Project 1");
            MyClass1 a = new MyClass1();
            // Console.WriteLine(a.myF1());  // myF1() is not visible here
            Console.WriteLine(a.myF2());

            MyClass3 c = new MyClass3();
            Console.WriteLine(c.myF5());
            Console.WriteLine(c.myF6());

            Console.ReadKey();
        }
    }
}
