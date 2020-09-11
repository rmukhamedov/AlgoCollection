using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text.RegularExpressions;
using System.Text;
using System;

class Solution {

    // Complete the encryption function below.
    static string encryption(string s) {
        var sChars = s.ToCharArray();
        var result = new List<char>();
        var print = new List<char>();

        for (int i = 0; i < sChars.Length; ++i)
        {
            if (sChars[i] != ' ')
            {
                result.Add(sChars[i]);
            }
        }

        var sqRoot = Math.Sqrt(Convert.ToDouble(result.Count));
        var floor = Convert.ToInt32(Math.Floor(sqRoot));
        var ceiling = Convert.ToInt32(Math.Ceiling(sqRoot));
        var count = result.Count;

        if (floor * ceiling < result.Count)
        {
            floor += 1;
        }

        for (int r = 0; r <= floor; ++r)
        {
            int c = r;
            while(c < result.Count)
            {
                print.Add(result[c]);
                --count;
                c += ceiling;
            }
            if (count == 0){
                break;
            }
            print.Add(' ');
        }

        return new string(print.ToArray()).Trim();
        
    }

    static void Main(string[] args) {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        string s = Console.ReadLine();

        string result = encryption(s);

        textWriter.WriteLine(result);

        textWriter.Flush();
        textWriter.Close();
    }
}