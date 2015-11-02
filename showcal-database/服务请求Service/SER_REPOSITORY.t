<?xml version="1.0" encoding="UTF-8"?>
<table>
     <name>SER_REPOSITORY</name>
     <meaning>知识库</meaning>
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
             <name>TYPE</name>
             <type>String</type>
             <meaning>知识库类型</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min>0</min>
             <max>50</max>
             <referenceType>Enum</referenceType>
             <referenceObject>PLATFORM,USER</referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>true</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>TAG</name>
             <type>String</type>
             <meaning>知识库标签</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>1</min>
             <max>1000</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>true</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>KEYWORD</name>
             <type>String</type>
             <meaning>知识库关键字</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>1</min>
             <max>1000</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>true</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>CONTENT</name>
             <type>String</type>
             <meaning>知识库内容</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min>1</min>
             <max>2000</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>true</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>SOURCE_ID</name>
             <type>Id</type>
             <meaning>来源ID</meaning>
             <description>来源ID(瘦咖转让)</description>
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
             <name>SOURCE_USER_ID</name>
             <type>Id</type>
             <meaning>来源用户ID</meaning>
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