<?xml version="1.0" encoding="UTF-8"?>
<table>
     <name>CMS_CATEGORY</name>
     <meaning>文章类别</meaning>
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
             <name>NAME</name>
             <type>String</type>
             <meaning>文章类别名称</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min>0</min>
             <max>100</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>true</isListable>
             <isExportable>true</isExportable>
             <isQueryable>true</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>DESCRIPTION</name>
             <type>String</type>
             <meaning>文章类别描述</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min></min>
             <max>500</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>true</isListable>
             <isExportable>true</isExportable>
             <isQueryable>true</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>IS_NEED_APPROVE</name>
             <type>Boolean</type>
             <meaning>是否需要审核</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min></min>
             <max></max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>true</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>APPROVE_USER_ID</name>
             <type>Id</type>
             <meaning>审核人ID</meaning>
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
             <name>APPROVE_USER_NAME</name>
             <type>String</type>
             <meaning>审核人员姓名</meaning>
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
             <name>ORDER_INDEX</name>
             <type>Integer</type>
             <meaning>排序索引</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min></min>
             <max></max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>true</isSortable>
        </column>
        <column>
             <name>PARENT_ID</name>
             <type>Id</type>
             <meaning>父类别ID</meaning>
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