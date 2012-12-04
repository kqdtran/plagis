        /**
         * Write a description of class PhoneBookEntry here.
         * 
         * @author (your name) 
         * @version (a version number or a date)
         */
        public class PhoneBookEntry
        {
            String name;
            long phoneNumber;
            public PhoneBookEntry(String aName, long aPhoneNumber){
                name = aName;
                phoneNumber = aPhoneNumber;
            }
            public String setName(){
                return name;
            }
            public long setPhoneNumber(){
                return phoneNumber;
            }
        
        }
