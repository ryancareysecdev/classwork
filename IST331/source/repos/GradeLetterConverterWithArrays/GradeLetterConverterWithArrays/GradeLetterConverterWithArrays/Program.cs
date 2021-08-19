/*
Author: Ryan Carey
Class: IST 331 Human Centered Design
Professor: Frank Ganther
Assignment: Third Grade Letter version.
*/

using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;

namespace GradeLetterConverterWithArrays
{
    class Program
    {
        private static TextReader configuration = File.OpenText("./GradeLetterConfig.txt");    
        private static readonly String[] gradeConfigArray = configuration.ReadLine().Split(' ');
        private static readonly String[] letterConfigArray = configuration.ReadLine().Split(' ');
        static double enteredGrade;

        static void Main(string[] args)
        {
            String userInput = "", letterGrade = "", gradeString = "", letterString = "";
            try
            {
                TextReader configuration = File.OpenText("./GradeLetterConfig.txt");
            }
            catch (Exception e)
            {
                Console.WriteLine(e.ToString());
                Console.WriteLine("The configuration file is not there or no good.");
            }
            configuration.Close();

            Console.WriteLine("This is a letter grade converter. Enter -1 to exit.");
            while (enteredGrade != -1)
            {
                Console.Write("Enter a Grade: ");
                userInput = Console.ReadLine();
                try
                {
                    enteredGrade = Double.Parse(userInput);
                }
                catch (Exception e)
                {
                    Console.WriteLine("Invalid grade. Try again.");
                    Console.WriteLine(e.ToString());
                }
                foreach (String bound in gradeConfigArray)
                {
                    if (enteredGrade < 0 || enteredGrade > 100)
                    {
                        letterGrade = "Invalid.";
                        continue;
                    }
                    else if (enteredGrade.CompareTo(Double.Parse(bound)) > -1)
                        letterGrade = letterConfigArray[Array.IndexOf(gradeConfigArray, bound)];
                }
                Console.WriteLine("The letter grade is: " + letterGrade);
            }
            foreach (String bound in gradeConfigArray)
            {
                gradeString = gradeString + bound + " ";
                
            }
            gradeString = gradeString.TrimEnd(' ');
            foreach (String letter in letterConfigArray)
            {
                letterString = letterString + letter + " ";

            }
            letterString = letterString.TrimEnd(' ');
            File.WriteAllText("./GradeLetterConfig.txt", gradeString + "\n" + letterString);
        }
    }
}