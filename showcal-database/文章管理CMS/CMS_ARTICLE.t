<?xml version="1.0" encoding="UTF-8"?>
<table>
     <name>CMS_ARTICLE</name>
     <meaning>文章</meaning>
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
             <name>TITLE</name>
             <type>String</type>
             <meaning>标题</meaning>
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
             <name>IS_ORIGINAL</name>
             <type>Boolean</type>
             <meaning>是否原创</meaning>
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
             <name>AUTHOR_NAME</name>
             <type>String</type>
             <meaning>作者</meaning>
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
             <name>COVER_ID</name>
             <type>Id</type>
             <meaning>封面图片ID</meaning>
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
             <name>IS_COVER_IN_BODY</name>
             <type>Boolean</type>
             <meaning>是否封面显示在正文中</meaning>
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
             <name>SUMMARY</name>
             <type>String</type>
             <meaning>摘要</meaning>
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
             <name>ORIGINAL_URL</name>
             <type>String</type>
             <meaning>原文链接</meaning>
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
             <name>CATEGORY_ID</name>
             <type>String</type>
             <meaning>分类ID</meaning>
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
             <name>KEYWORDS</name>
             <type>String</type>
             <meaning>关键字</meaning>
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
             <name>IS_SUBMIT</name>
             <type>Boolean</type>
             <meaning>是否已提交</meaning>
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
             <name>SUBMIT_USER_ID</name>
             <type>Id</type>
             <meaning>提交用户ID</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min></min>
             <max></max>
             <referenceType>FK</referenceType>
             <referenceObject>SYS_USER.USER_ID</referenceObject>
             <isListable>true</isListable>
             <isExportable>true</isExportable>
             <isQueryable>true</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>SUBMIT_USER_NAME</name>
             <type>String</type>
             <meaning>提交用户姓名</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>0</min>
             <max>50</max>
             <referenceType>FK</referenceType>
             <referenceObject>SYS_USER.USER_NAME</referenceObject>
             <isListable>true</isListable>
             <isExportable>true</isExportable>
             <isQueryable>true</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>SUBMIT_TIME</name>
             <type>DateTime</type>
             <meaning>提交时间</meaning>
             <description></description>
             <isRequired>false</isRequired>
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
             <name>IS_APPROVED</name>
             <type>Boolean</type>
             <meaning>是否已审批</meaning>
             <description></description>
             <isRequired>false</isRequired>
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
             <name>APPROVE_USER_ID</name>
             <type>Id</type>
             <meaning>审批用户ID</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min></min>
             <max></max>
             <referenceType>FK</referenceType>
             <referenceObject>SYS_USER.USER_ID</referenceObject>
             <isListable>true</isListable>
             <isExportable>true</isExportable>
             <isQueryable>true</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>APPROVE_USER_NAME</name>
             <type>String</type>
             <meaning>审批用户姓名</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>0</min>
             <max>50</max>
             <referenceType>FK</referenceType>
             <referenceObject>SYS_USER.USER_NAME</referenceObject>
             <isListable>true</isListable>
             <isExportable>true</isExportable>
             <isQueryable>true</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>APPROVE_TIME</name>
             <type>DateTime</type>
             <meaning>审批时间</meaning>
             <description></description>
             <isRequired>false</isRequired>
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
             <name>APPROVE_RESULT</name>
             <type>String</type>
             <meaning>审批结果</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>0</min>
             <max>50</max>
             <referenceType>Enum</referenceType>
             <referenceObject>AGREED:同意;DISAGREED:否决</referenceObject>
             <isListable>true</isListable>
             <isExportable>true</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
     </columns>
</table>