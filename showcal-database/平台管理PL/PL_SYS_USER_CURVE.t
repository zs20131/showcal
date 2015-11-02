<?xml version="1.0" encoding="UTF-8"?>
<table>
     <name>PL_SYS_USER_CURVE</name>
     <meaning>用户身体变化曲线</meaning>
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
             <name>USER_ID</name>
             <type>Id</type>
             <meaning>关联用户ID</meaning>
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
             <name>TYPE</name>
             <type>String</type>
             <meaning>记录类型</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min></min>
             <max></max>
             <referenceType>Enum</referenceType>
             <referenceObject>HEIGHT(身高)，WEIGHT（体重）,WAISTLINE(腰围)，HIPLINE（臀围）</referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>VALUE</name>
             <type>Decimal</type>
             <meaning></meaning>
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
             <name>RECORD_DATE</name>
             <type>String</type>
             <meaning>记录日期</meaning>
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
     </columns>
</table>