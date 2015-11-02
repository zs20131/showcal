<?xml version="1.0" encoding="UTF-8"?>
<table>
     <name>SER_MESSAGE</name>
     <meaning>消息内容</meaning>
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
             <meaning>消息类型</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>0</min>
             <max>50</max>
             <referenceType>Enum</referenceType>
             <referenceObject>QUESTION,ANSWER</referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>MESSAGE_TYPE</name>
             <type>String</type>
             <meaning>消息内容类型</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>0</min>
             <max>50</max>
             <referenceType>Enum</referenceType>
             <referenceObject>TEXT(文本),PICTURE(图片)</referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>CONTENT</name>
             <type>String</type>
             <meaning>消息内容</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>1</min>
             <max>1000</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>SERVICE_ID</name>
             <type>String</type>
             <meaning>问题/答案ＩＤ</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>0</min>
             <max>50</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>CREATE_USER_NAME</name>
             <type>String</type>
             <meaning>创建人昵称</meaning>
             <description></description>
             <isRequired>false</isRequired>
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