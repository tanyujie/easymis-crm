/*package org.easymis.crm.standard.message.handler;

public class AbstractMessageHandler implements MessageHandler {

    *//**
     * 参数校验
     * @param messageTemplate
     *//*
    @Override
    public abstract void check(MessageTemplate messageTemplate);

    *//**
     * 执行发送短信
     * @param messageTemplate
     * @return
     *//*
    @Override
    public abstract Boolean execute(MessageTemplate messageTemplate) ;

    *//**
     * 发送失败回调处理
     * @param messageTemplate
     *//*
    @Override
    public abstract void fail(MessageTemplate messageTemplate);

    *//**
     * 发送短信主入口
     * @param messageTemplate
     *//*
    @Override
    public void handleMessage(MessageTemplate messageTemplate) {
        check(messageTemplate);
        if(!execute(messageTemplate)){
            fail(messageTemplate);
        }
    }
}*/