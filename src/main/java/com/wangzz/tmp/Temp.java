package com.wangzz.tmp;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Temp {

//    public static void main(String[] args) {
//        {
//            if(isConnected){
//                throw new JSchException("session is already connected");
//            }
//
//            io=new IO();
//            if(random==null){
//                try{
//                    Class c=Class.forName(getConfig("random"));
//                    random=(Random)(c.newInstance());
//                }
//                catch(Exception e){
//                    throw new JSchException(e.toString(), e);
//                }
//            }
//            Packet.setRandom(random);
//
//            if(JSch.getLogger().isEnabled(Logger.INFO)){
//                JSch.getLogger().log(Logger.INFO,
//                        "Connecting to "+host+" port "+port);
//            }
//
//            try	{
//                int i, j;
//
//                if(proxy==null){
//                    InputStream in;
//                    OutputStream out;
//                    if(socket_factory==null){
//                        socket=Util.createSocket(host, port, connectTimeout);
//                        in=socket.getInputStream();
//                        out=socket.getOutputStream();
//                    }
//                    else{
//                        socket=socket_factory.createSocket(host, port);
//                        in=socket_factory.getInputStream(socket);
//                        out=socket_factory.getOutputStream(socket);
//                    }
//                    //if(timeout>0){ socket.setSoTimeout(timeout); }
//                    socket.setTcpNoDelay(true);
//                    io.setInputStream(in);
//                    io.setOutputStream(out);
//                }
//                else{
//                    synchronized(proxy){
//                        proxy.connect(socket_factory, host, port, connectTimeout);
//                        io.setInputStream(proxy.getInputStream());
//                        io.setOutputStream(proxy.getOutputStream());
//                        socket=proxy.getSocket();
//                    }
//                }
//
//                if(connectTimeout>0 && socket!=null){
//                    socket.setSoTimeout(connectTimeout);
//                }
//
//                isConnected=true;
//
//                if(JSch.getLogger().isEnabled(Logger.INFO)){
//                    JSch.getLogger().log(Logger.INFO,
//                            "Connection established");
//                }
//
//                jsch.addSession(this);
//
//                {
//                    // Some Cisco devices will miss to read '\n' if it is sent separately.
//                    byte[] foo=new byte[V_C.length+1];
//                    System.arraycopy(V_C, 0, foo, 0, V_C.length);
//                    foo[foo.length-1]=(byte)'\n';
//                    io.put(foo, 0, foo.length);
//                }
//
//                while(true){
//                    i=0;
//                    j=0;
//                    while(i<buf.buffer.length){
//                        j=io.getByte();
//                        if(j<0)break;
//                        buf.buffer[i]=(byte)j; i++;
//                        if(j==10)break;
//                    }
//                    if(j<0){
//                        throw new JSchException("connection is closed by foreign host");
//                    }
//
//                    if(buf.buffer[i-1]==10){    // 0x0a
//                        i--;
//                        if(i>0 && buf.buffer[i-1]==13){  // 0x0d
//                            i--;
//                        }
//                    }
//
//                    if(i<=3 ||
//                            ((i!=buf.buffer.length) &&
//                                    (buf.buffer[0]!='S'||buf.buffer[1]!='S'||
//                                            buf.buffer[2]!='H'||buf.buffer[3]!='-'))){
//                        // It must not start with 'SSH-'
//                        //System.err.println(new String(buf.buffer, 0, i);
//                        continue;
//                    }
//
//                    if(i==buf.buffer.length ||
//                            i<7 ||                                      // SSH-1.99 or SSH-2.0
//                            (buf.buffer[4]=='1' && buf.buffer[6]!='9')  // SSH-1.5
//                    ){
//                        throw new JSchException("invalid server's version string");
//                    }
//                    break;
//                }
//
//                V_S=new byte[i]; System.arraycopy(buf.buffer, 0, V_S, 0, i);
//                //System.err.println("V_S: ("+i+") ["+new String(V_S)+"]");
//
//                if(JSch.getLogger().isEnabled(Logger.INFO)){
//                    JSch.getLogger().log(Logger.INFO,
//                            "Remote version string: "+Util.byte2str(V_S));
//                    JSch.getLogger().log(Logger.INFO,
//                            "Local version string: "+Util.byte2str(V_C));
//                }
//
//                send_kexinit();
//
//                buf=read(buf);
//                if(buf.getCommand()!=SSH_MSG_KEXINIT){
//                    in_kex=false;
//                    throw new JSchException("invalid protocol: "+buf.getCommand());
//                }
//
//                if(JSch.getLogger().isEnabled(Logger.INFO)){
//                    JSch.getLogger().log(Logger.INFO,
//                            "SSH_MSG_KEXINIT received");
//                }
//
//                KeyExchange kex=receive_kexinit(buf);
//
//                while(true){
//                    buf=read(buf);
//                    if(kex.getState()==buf.getCommand()){
//                        kex_start_time=System.currentTimeMillis();
//                        boolean result=kex.next(buf);
//                        if(!result){
//                            //System.err.println("verify: "+result);
//                            in_kex=false;
//                            throw new JSchException("verify: "+result);
//                        }
//                    }
//                    else{
//                        in_kex=false;
//                        throw new JSchException("invalid protocol(kex): "+buf.getCommand());
//                    }
//                    if(kex.getState()==KeyExchange.STATE_END){
//                        break;
//                    }
//                }
//
//                try{
//                    long tmp=System.currentTimeMillis();
//                    in_prompt = true;
//                    checkHost(host, port, kex);
//                    in_prompt = false;
//                    kex_start_time+=(System.currentTimeMillis()-tmp);
//                }
//                catch(JSchException ee){
//                    in_kex=false;
//                    in_prompt = false;
//                    throw ee;
//                }
//
//                send_newkeys();
//
//                // receive SSH_MSG_NEWKEYS(21)
//                buf=read(buf);
//                //System.err.println("read: 21 ? "+buf.getCommand());
//                if(buf.getCommand()==SSH_MSG_NEWKEYS){
//
//                    if(JSch.getLogger().isEnabled(Logger.INFO)){
//                        JSch.getLogger().log(Logger.INFO,
//                                "SSH_MSG_NEWKEYS received");
//                    }
//
//                    receive_newkeys(buf, kex);
//                }
//                else{
//                    in_kex=false;
//                    throw new JSchException("invalid protocol(newkyes): "+buf.getCommand());
//                }
//
//                try{
//                    String s = getConfig("MaxAuthTries");
//                    if(s!=null){
//                        max_auth_tries = Integer.parseInt(s);
//                    }
//                }
//                catch(NumberFormatException e){
//                    throw new JSchException("MaxAuthTries: "+getConfig("MaxAuthTries"), e);
//                }
//
//                boolean auth=false;
//                boolean auth_cancel=false;
//
//                UserAuth ua=null;
//                try{
//                    Class c=Class.forName(getConfig("userauth.none"));
//                    ua=(UserAuth)(c.newInstance());
//                }
//                catch(Exception e){
//                    throw new JSchException(e.toString(), e);
//                }
//
//                auth=ua.start(this);
//
//                String cmethods=getConfig("PreferredAuthentications");
//
//                String[] cmethoda=Util.split(cmethods, ",");
//
//                String smethods=null;
//                if(!auth){
//                    smethods=((UserAuthNone)ua).getMethods();
//                    if(smethods!=null){
//                        smethods=smethods.toLowerCase();
//                    }
//                    else{
//                        // methods: publickey,password,keyboard-interactive
//                        //smethods="publickey,password,keyboard-interactive";
//                        smethods=cmethods;
//                    }
//                }
//
//                String[] smethoda=Util.split(smethods, ",");
//
//                int methodi=0;
//
//                loop:
//                while(true){
//
//                    while(!auth &&
//                            cmethoda!=null && methodi<cmethoda.length){
//
//                        String method=cmethoda[methodi++];
//                        boolean acceptable=false;
//                        for(int k=0; k<smethoda.length; k++){
//                            if(smethoda[k].equals(method)){
//                                acceptable=true;
//                                break;
//                            }
//                        }
//                        if(!acceptable){
//                            continue;
//                        }
//
//                        //System.err.println("  method: "+method);
//
//                        if(JSch.getLogger().isEnabled(Logger.INFO)){
//                            String str="Authentications that can continue: ";
//                            for(int k=methodi-1; k<cmethoda.length; k++){
//                                str+=cmethoda[k];
//                                if(k+1<cmethoda.length)
//                                    str+=",";
//                            }
//                            JSch.getLogger().log(Logger.INFO,
//                                    str);
//                            JSch.getLogger().log(Logger.INFO,
//                                    "Next authentication method: "+method);
//                        }
//
//                        ua=null;
//                        try{
//                            Class c=null;
//                            if(getConfig("userauth."+method)!=null){
//                                c=Class.forName(getConfig("userauth."+method));
//                                ua=(UserAuth)(c.newInstance());
//                            }
//                        }
//                        catch(Exception e){
//                            if(JSch.getLogger().isEnabled(Logger.WARN)){
//                                JSch.getLogger().log(Logger.WARN,
//                                        "failed to load "+method+" method");
//                            }
//                        }
//
//                        if(ua!=null){
//                            auth_cancel=false;
//                            try{
//                                auth=ua.start(this);
//                                if(auth &&
//                                        JSch.getLogger().isEnabled(Logger.INFO)){
//                                    JSch.getLogger().log(Logger.INFO,
//                                            "Authentication succeeded ("+method+").");
//                                }
//                            }
//                            catch(JSchAuthCancelException ee){
//                                auth_cancel=true;
//                            }
//                            catch(JSchPartialAuthException ee){
//                                String tmp = smethods;
//                                smethods=ee.getMethods();
//                                smethoda=Util.split(smethods, ",");
//                                if(!tmp.equals(smethods)){
//                                    methodi=0;
//                                }
//                                //System.err.println("PartialAuth: "+methods);
//                                auth_cancel=false;
//                                continue loop;
//                            }
//                            catch(RuntimeException ee){
//                                throw ee;
//                            }
//                            catch(JSchException ee){
//                                throw ee;
//                            }
//                            catch(Exception ee){
//                                //System.err.println("ee: "+ee); // SSH_MSG_DISCONNECT: 2 Too many authentication failures
//                                if(JSch.getLogger().isEnabled(Logger.WARN)){
//                                    JSch.getLogger().log(Logger.WARN,
//                                            "an exception during authentication\n"+ee.toString());
//                                }
//                                break loop;
//                            }
//                        }
//                    }
//                    break;
//                }
//
//                if(!auth){
//                    if(auth_failures >= max_auth_tries){
//                        if(JSch.getLogger().isEnabled(Logger.INFO)){
//                            JSch.getLogger().log(Logger.INFO,
//                                    "Login trials exceeds "+max_auth_tries);
//                        }
//                    }
//                    if(auth_cancel)
//                        throw new JSchException("Auth cancel");
//                    throw new JSchException("Auth fail");
//                }
//
//                if(socket!=null && (connectTimeout>0 || timeout>0)){
//                    socket.setSoTimeout(timeout);
//                }
//
//                isAuthed=true;
//
//                synchronized(lock){
//                    if(isConnected){
//                        connectThread=new Thread(this);
//                        connectThread.setName("Connect thread "+host+" session");
//                        if(daemon_thread){
//                            connectThread.setDaemon(daemon_thread);
//                        }
//                        connectThread.start();
//
//                        requestPortForwarding();
//                    }
//                    else{
//                        // The session has been already down and
//                        // we don't have to start new thread.
//                    }
//                }
//            }
//            catch(Exception e) {
//                in_kex=false;
//                try{
//                    if(isConnected){
//                        String message = e.toString();
//                        packet.reset();
//                        buf.checkFreeSize(1+4*3+message.length()+2+buffer_margin);
//                        buf.putByte((byte)SSH_MSG_DISCONNECT);
//                        buf.putInt(3);
//                        buf.putString(Util.str2byte(message));
//                        buf.putString(Util.str2byte("en"));
//                        write(packet);
//                    }
//                }
//                catch(Exception ee){}
//                try{ disconnect(); } catch(Exception ee){ }
//                isConnected=false;
//                //e.printStackTrace();
//                if(e instanceof RuntimeException) throw (RuntimeException)e;
//                if(e instanceof JSchException) throw (JSchException)e;
//                throw new JSchException("Session.connect: "+e);
//            }
//            finally{
//                Util.bzero(this.password);
//                this.password=null;
//            }
//        }
//    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class DingDingMarkDownMsg {
        private String msgtype;
        private String markdown;
        private String at;
    }


    public static void main(String[] args) {
//        InnerClass innerClass = new InnerClass();
//        InnerClass.InnerSubClass innerSubClass = innerClass.new InnerSubClass();
//        new InnerClass.InnerStaticSubClass();
//        System.out.println("aaa");
//
//        loop:
//        while (true) {
//            System.out.println("bbb");
//
//            while (true) {
//                System.out.println("ccc");
//                continue loop;
//            }
//        }
       // System.out.println("ddd");
        int a = 1;
        {
            a = 2;
        }
        testStack();
    }

    private static void testStack() {
        testStack();
    }

}
