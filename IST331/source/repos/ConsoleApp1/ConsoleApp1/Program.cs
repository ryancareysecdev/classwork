using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            String userInput = "", letterGrade = "Not Valid", exitChar = "q";
            double enteredGrade = -1;
            // The code provided will print ‘Hello World’ to the console.
            // Press Ctrl+F5 (or go to Debug > Start Without Debugging) to run your app.
            while (userInput != exitChar)
            {
                Console.Write("Enter a Grade: ");
                userInput = Console.ReadLine();
                try
                {
                    if (Double.Parse(userInput) >= 0)
                        enteredGrade = Double.Parse(userInput);
                }
                catch (Exception e) { Console.WriteLine(e.ToString()); }
                if (enteredGrade > 0)
                {
                    letterGrade = "F";
                }
                if (enteredGrade >= 60)
                {
                    letterGrade = "D";
                }
                if (enteredGrade >= 70)
                {
                    letterGrade = "C";
                }
                if (enteredGrade >= 77)
                {
                    letterGrade = "C+";
                }
                if (enteredGrade >= 80)
                {
                    letterGrade = "B-";
                }
                if (enteredGrade >= 83)
                {
                    letterGrade = "B";
                }
                if (enteredGrade >= 87)
                {
                    letterGrade = "B+";
                }
                if (enteredGrade >= 90)
                {
                    letterGrade = "A-";
                }
                if (enteredGrade >= 93)
                {
                    letterGrade = "A";
                }
                Console.WriteLine("The letter grade is: " + letterGrade);
            }
            // Go to http://aka.ms/dotnet-get-started-console to continue learning how to build a console app! 
        }
    }
}
