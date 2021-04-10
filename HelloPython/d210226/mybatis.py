import mybatis_mapper2sql

mapper, xml_raw_text = mybatis_mapper2sql.create_mapper(xml='mybatis_sample.xml')

# statement = mybatis_mapper2sql.get_statement(mapper)

statement = mybatis_mapper2sql.get_child_statement(mapper, 'select')
print("select", statement)
statement = mybatis_mapper2sql.get_child_statement(mapper, 'insert')
print("insert", statement)
statement = mybatis_mapper2sql.get_child_statement(mapper, 'update')
print("update", statement)
statement = mybatis_mapper2sql.get_child_statement(mapper, 'delete', '123')
print("delete", statement)
