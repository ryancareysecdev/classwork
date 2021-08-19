using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DogAdoption
{
    public class Dog
    {
        private String name, birthdate, breed, weight, months, picFileName;
        private bool upToDate;
        public Dog(String name, String birthdate, String breed, String weight, Boolean upToDate, String months, String picFileName)
        {
            this.name = name;
            this.birthdate = birthdate;
            this.breed = breed;
            this.weight = weight;
            this.upToDate = upToDate;
            this.months = months;
            this.picFileName = picFileName;
        }

        public String getName()
        {
            return name;
        }
        public String getBDay()
        {
            return birthdate;
        }
        public String getBreed()
        {
            return breed;
        }
        public String getWeight()
        {
            return weight;
        }
        public String isIpToDate()
        {
            return upToDate.ToString();
        }
        public String getMonths()
        {
            return months;
        }
        public String getPic()
        {
            return picFileName;
        }
    }
}
