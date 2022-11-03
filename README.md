Conditions: 
Use java & spring
Use an in-memory database

The goal is to create an application that allows uploading and getting a csv file.
The sample csv file can be found here: 

source	codeListCode	code	displayValue	longDescription	fromDate	toDate	sortingPriority
ZIB	ZIB001	271636001	Polsslag regelmatig	The long description is necessary	01-01-2019		1
ZIB	ZIB001	61086009	Polsslag onregelmatig		01-01-2019		2
ZIB	ZIB001	Type 1	Losse harde keutels, zoals noten		01-01-2019		
ZIB	ZIB002	Type 2	Als een worst, maar klonterig		01-01-2019		
ZIB	ZIB002	Type 3	Als een worst, maar met barstjes aan de buitenkant		01-01-2019		
ZIB	ZIB002	Type 4	Als een worst of slang, glad en zacht		01-01-2019		
ZIB	ZIB002	Type 5	Zachte keutels met duidelijke randen		01-01-2019		
ZIB	ZIB002	Type 6	Zachte stukjes met gehavende randen		01-01-2019		
ZIB	ZIB002	Type 7	Helemaal vloeibaar		01-01-2019		
ZIB	ZIB003	307047009	Rectale temperatuur		01-01-2019		1
ZIB	ZIB003	415945006	Orale temperatuur (onder de tong)		01-01-2019		2
ZIB	ZIB003	415882003	Axillaire temperatuur (onder de oksel)		01-01-2019		
ZIB	ZIB003	415929009	Inguinale temperatuur (via de lies)		01-01-2019		
ZIB	ZIB003	415974002	Tympanische temperatuur		01-01-2019		3
ZIB	ZIB003	415922000	Temporale temperatuur		01-01-2019		
ZIB	ZIB003	364246006	Vaginale temperatuur		01-01-2019		
ZIB	ZIB003	698832009	Blaastemperatuur		01-01-2019		
ZIB	ZIB003	276885007	Kern temperatuur (invasief gemeten)		01-01-2019		

The first line of the file are the headers!
Note: The field code is unique

The application allows interaction through a Rest endpoint that allows the user to:

upload the data
Fetch all data
Fetch by code
Delete all data

Data upload:
Store to a database. The in memory database table will contain the fields as described on the csv file 