package template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class JDBCTemlpate {

    private DataSource dataSource;

    public JDBCTemlpate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql,RowMapper<?> rowMapper,Object[] values){

        try{
            //1.获取连接
            Connection conn = this.getConnection();
            //2.创建语句集
            PreparedStatement ps = this.createPrepareStatement(conn,sql);
            //3.执行语句集
            ResultSet rs = this.executeQuery(ps,values);
            //4.处理结果集
            List<?> result = this.parseResultSet(rs,rowMapper);
            //5关闭结果集
            this.closeReultSet(rs);
            //6.关闭语句集
            this.closePrepareStatement(ps);
            //7.关闭连接
            this.closeConnection(conn);
            
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    protected List<?> parseResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception {
        List<Object> list = new ArrayList<Object>();
        int rowNum = 1;
        while(rs.next()){
            list.add(rowMapper.mapRow(rs,rowNum ++));
        }
        return list;
    };

    protected void closeConnection(Connection conn) throws Exception {
        conn.close();
    };

    protected void closePrepareStatement(PreparedStatement ps) throws Exception {
        ps.close();
    };

    protected void closeReultSet(ResultSet rs) throws Exception {
        rs.close();
    };

    protected ResultSet executeQuery(PreparedStatement ps, Object[] values) throws Exception{
        for(int i=0;i<values.length;i++){
            ps.setObject(i,values[i]);
        }
        return ps.executeQuery();
    };

    protected PreparedStatement createPrepareStatement(Connection conn, String sql) throws Exception {
        return conn.prepareStatement(sql);
    };

    protected Connection getConnection() throws Exception {
        return this.dataSource.getConnection();
    };

}
