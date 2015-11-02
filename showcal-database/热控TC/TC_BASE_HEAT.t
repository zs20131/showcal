<?xml version="1.0" encoding="UTF-8"?>
<table>
     <name>TC_BASE_HEAT</name>
     <meaning>基础热量设置</meaning>
     <description></description>
     <isByTenant>false</isByTenant>
     <uniqueIndex></uniqueIndex>
     <columns>
        <column>
             <name>ID</name>
             <type>Id</type>
             <meaning>主键</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min></min>
             <max></max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>true</isListable>
             <isExportable>true</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>SEX</name>
             <type>String</type>
             <meaning>性别</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min>0</min>
             <max>50</max>
             <referenceType>Enum</referenceType>
             <referenceObject>MALE(男),FEMALE(女)</referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>START_AGE</name>
             <type>Integer</type>
             <meaning>起始年龄</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min>0</min>
             <max>120</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>END_AGE</name>
             <type>Integer</type>
             <meaning>结束年龄</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min>0</min>
             <max>120</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>START_HEIGHT</name>
             <type>Integer</type>
             <meaning>起始身高</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min>40</min>
             <max>250</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>END_HEIGHT</name>
             <type>Integer</type>
             <meaning>结束身高</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min>40</min>
             <max>250</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>DISEASE_ID</name>
             <type>Id</type>
             <meaning>疾病情况</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min></min>
             <max></max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>BASE_HEAT</name>
             <type>String</type>
             <meaning>基础热量值</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min>0</min>
             <max>50</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
     </columns>
</table>