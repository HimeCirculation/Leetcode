class Solution
{
public:
    static string convert(string& s, const unsigned short int numRows)
    {

        unsigned short int length = s.length();
        unsigned short int width = numRows - 1;
        
        if (length <= 1 || numRows == 1)
        {
            return s;
        }

        //string output = "";
        char* output = new char[length + 1];
        unsigned short int k = 0;


        for (unsigned int row = 0; row < numRows; row++)
        {
            unsigned short int column = 0;
            unsigned short int index = row;
            for (unsigned short int n = 1; index < length; n++)
            {
                //output += s[index];
                output[k] = s[index];
                k++;

                column += width - row;
                index = 2 * column + row;
                if (row != 0 && row != width && index < length)
                {
                    //output += s[index];
                    output[k] = s[index];
                    k++;

                }

                column = n * width;
                index = 2 * column + row;
            }
        }
        output[length] = '\0';
        return output;
    }
};