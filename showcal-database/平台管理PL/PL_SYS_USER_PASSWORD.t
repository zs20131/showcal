<?xml version="1.0" encoding="UTF-8"?>
<table>
     <name>PL_SYS_USER_PASSWORD</name>
     <meaning>用户密码表,考虑安全，纯扩展表</meaning>
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
             <name>LOGIN_PASSWORD</name>
             <type>String</type>
             <meaning>登录密码</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>1</min>
             <max>500</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>LOGIN_SALT</name>
             <type>String</type>
             <meaning>登录加密盐</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>1</min>
             <max>36</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>TRANSACTION_PASSWORD</name>
             <type>String</type>
             <meaning>交易密码</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>1</min>
             <max>500</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>TRANSACTION_SALT</name>
             <type>String</type>
             <meaning>交易加密盐</meaning>
             <description></description>
             <isRequired>false</isRequired>
             <min>1</min>
             <max>36</max>
             <referenceType></referenceType>
             <referenceObject></referenceObject>
             <isListable>false</isListable>
             <isExportable>false</isExportable>
             <isQueryable>false</isQueryable>
             <isSortable>false</isSortable>
        </column>
        <column>
             <name>NEED_CHANGE_LOGIN</name>
             <type>Boolean</type>
             <meaning>是否需要更改密码</meaning>
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