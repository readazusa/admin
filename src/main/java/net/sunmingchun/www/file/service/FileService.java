package net.sunmingchun.www.file.service;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

/**
 * net.sunmingchun.www.file.service
 * Created by smc
 * date on 2016/3/15.
 * Email:sunmch@163.com
 */
public class FileService {

    private static final String LISTENER_FILE_DIR = "/file/listener/";

    public static void main(String[] args) {

        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path dir = Paths.get(LISTENER_FILE_DIR);
            dir.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY,StandardWatchEventKinds.ENTRY_CREATE);
            while (true) {
                WatchKey key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    System.out.println(event.context() + "发生了" + event.kind() + "事件");
                    WatchEvent.Kind<?> kind = event.kind();
                    if (kind == StandardWatchEventKinds.OVERFLOW) {
                        continue;
                    }
                    WatchEvent<Path> ev = (WatchEvent<Path>) event;
                    Path fileKind = ev.context();
                    File file = fileKind.toFile();
                    long l = file.length();
                    String fileName = file.getName();
                    String[] fileNames = fileName.split("_");
//                    if (fileNames.length > 1) {
//                        String dateDir = fileNames[1];
//                        int index = dateDir.lastIndexOf(".");
//                        File parentFile = new File(LISTENER_FILE_DIR + dateDir.substring(0,index));
//                        if (!parentFile.exists()) {
//                            parentFile.mkdir();
//                        }
//                        FileUtils.copyFile(new File(LISTENER_FILE_DIR+fileName), new File(parentFile, fileName));
//                    }
//                    System.out.println("================");
                }
                if (!key.reset()) {
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
