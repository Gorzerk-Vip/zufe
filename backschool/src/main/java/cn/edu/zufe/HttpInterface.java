package cn.edu.zufe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpInterface {
    /**
     * ��post��get��ʽ���öԷ��ӿڷ���
     * @param pathUrl
     */
    public static void doPostOrGet(String pathUrl, String data){
        OutputStreamWriter out = null;
        BufferedReader br = null;
        String result = "";
        try {
            URL url = new URL(pathUrl);
            //�򿪺�url֮�������
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //����ʽ
            conn.setRequestMethod("POST");
            //conn.setRequestMethod("GET");

            //����ͨ�õ���������
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            //DoOutput�����Ƿ���httpUrlConnection�����DoInput�����Ƿ��httpUrlConnection���룬���ⷢ��post�����������������
            conn.setDoOutput(true);
            conn.setDoInput(true);

            /**
             * �����������룬���ǵ��õ�����http�ӿ�
             */
            //��ȡURLConnection�����Ӧ�������
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            //�����������������
            out.write(data);
            //flush������Ļ���
            out.flush();

            /**
             * ����Ĵ����൱�ڣ���ȡ���õ�����http�ӿں󷵻صĽ��
             */
            //��ȡURLConnection�����Ӧ��������
            InputStream is = conn.getInputStream();
            //����һ���ַ�������
            br = new BufferedReader(new InputStreamReader(is));
            String str = "";
            while ((str = br.readLine()) != null){
                result += str;
            }
            System.out.println(result);
            //�ر���
            is.close();
            //�Ͽ����ӣ�disconnect���ڵײ�tcp socket���ӿ���ʱ���жϣ�������ڱ������߳�ʹ�þͲ��жϡ�
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (out != null){
                    out.close();
                }
                if (br != null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}