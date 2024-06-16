### Chris Pilkington  
Copyright ©  
http://chris.iluo.net/ 

### License

This program is free software; you can redistribute it and/or  
modify it under the terms of the GNU General Public License  
as published by the Free Software Foundation; either version 2  
of the License, or (at your option) any later version. 

This program is distributed in the hope that it will be useful,  
but WITHOUT ANY WARRANTY; without even the implied warranty of  
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the  
GNU General Public License for more details. 

You should have received a copy of the GNU General Public License  
along with this program; if not, write to the Free Software  
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA. 

### Description

This application generates a [KML][1] file of post code points from importing parts into Google Maps. 

### Requirements

- Java
- Maven

Fedora:  
```bash
sudo dnf install java maven
```
Ubuntu:  
```bash
sudo apt-get install java maven
```

```bash
git clone https://github.com/pilkch/postcodes.git 
```

### Building

```bash
cd postcodes
mvn compile
mvn package
```

### Usage

```bash
java -cp ./target/postcodes-1.0.2.jar net.iluo.postcodes.Application
```  

If everything worked, these files should now be in your current folder:  
- points_au.kml  
- points_nz.kml  

### Credit

This application is created by Christopher Pilkington.  
It uses data from other websites. 

### Resources

Australian Post Codes  
Copyright 2007, Corra Communications  
All rights reserved  
[Corra Communications][2]  

New Zealand Post Codes  
Copyright 2007, Noodles' Blog  
All rights reserved  
[Noodles' Blog][3] 

KML Reference  
[KML][1] </body> </html>

 [1]: https://code.google.com/apis/kml/documentation/kml_tut.html#placemarks
 [2]: http://www.corra.com.au/support/downloads/
 [3]: http://www.noodles.net.nz/2007/09/14/new-zealand-postcode-database-v2/

