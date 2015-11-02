<?xml version="1.0" encoding="UTF-8"?>
<table>
     <name>PL_COMMENT_POST</name>
     <meaning>评论表</meaning>
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
             <name>PARENT_ID</name>
             <type>Id</type>
             <meaning>父评论发布ID</meaning>
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
             <name>ROOT_ID</name>
             <type>Id</type>
             <meaning>根评论发布ID</meaning>
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
             <name>CONTENT</name>
             <type>String</type>
             <meaning>评论内容</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>1</min>
             <max>4000</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>IS_ANONYMOUS</name>
             <type>Boolean</type>
             <meaning>是否匿名</meaning>
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
             <name>USER_ID</name>
             <type>Id</type>
             <meaning>评论用户ID</meaning>
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
             <name>POST_TIME</name>
             <type>DateTime</type>
             <meaning>评论发布时间</meaning>
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
             <name>THREAD_ID</name>
             <type>Id</type>
             <meaning>评论对象ID</meaning>
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
             <name>BUSINESS_TYPE</name>
             <type>String</type>
             <meaning>业务类型</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>1</min>
             <max>50</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>BUSINESS_ID</name>
             <type>Id</type>
             <meaning>业务ID</meaning>
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
             <name>BUSINESS_CATEGORY</name>
             <type>String</type>
             <meaning>业务类别</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>1</min>
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