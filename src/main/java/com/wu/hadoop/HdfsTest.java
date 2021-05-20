package com.wu.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;


public class HdfsTest {
    public static void main(String[] args) throws Exception {
        test1();
    }

    //kerberos
    public static void test1() throws Exception {

        Configuration conf = new Configuration();
        //这里设置namenode
        conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
//        conf.set("dfs.nameservices", "nameservice1");
        conf.set("fs.defaultFS", "hdfs://localhost:9000/user/hadoop/input/");
        FileSystem fileSystem1 = FileSystem.get(conf);
        //测试访问情况
        Path path = new Path("/user/hadoop");
        RemoteIterator<LocatedFileStatus> list = fileSystem1.listFiles(path, true);
        while (list.hasNext()) {
            LocatedFileStatus fileStatus = list.next();
            System.out.println("====" + fileStatus.getPath());
        }
    }
}