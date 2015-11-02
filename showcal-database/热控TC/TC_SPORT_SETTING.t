<?xml version="1.0" encoding="UTF-8"?>
<table>
     <name>TC_SPORT_SETTING</name>
     <meaning>运动主数据</meaning>
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
             <meaning>运动名称</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min>1</min>
             <max>500</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>true</isListable>
             <isExportable>false</isExportable>
             <isQueryable>true</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>TYPE</name>
             <type>String</type>
             <meaning>类型</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min>1</min>
             <max>100</max>
             <referenceType>Enum</referenceType>
             <referenceObject>TEXT(文字),PICTURE(图片),VIDEO(视频），链接（URL）</referenceObject>
             <isListable>true</isListable>
             <isExportable>false</isExportable>
             <isQueryable>true</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>URL</name>
             <type>String</type>
             <meaning>链接地址</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min>0</min>
             <max>50</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>true</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>COVER</name>
             <type>Id</type>
             <meaning>封面图片</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min></min>
             <max></max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>true</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>BURN_HEAT</name>
             <type>Decimal</type>
             <meaning>消耗热量</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min></min>
             <max></max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>true</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>CONTENT</name>
             <type>String</type>
             <meaning>运动说明内容</meaning>
             <description></description>
             <isRequired>true</isRequired>
             <min>0</min>
             <max>50</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>true</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
     </columns>
</table>