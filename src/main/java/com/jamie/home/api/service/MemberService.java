package com.jamie.home.api.service;

import com.jamie.home.api.model.common.MEMBER;
import com.jamie.home.api.model.common.ROLE;
import com.jamie.home.api.model.common.SEARCH;
import com.jamie.home.util.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberService extends BasicService{
    public List<MEMBER> list(SEARCH search) {
        List<MEMBER> result = memberDao.getListMember(search);
        for(int i=0; i<result.size(); i++){
            setDetailInfo(result.get(i));
        }
        return result;
    }

    public Integer listCnt(SEARCH search) {
        return memberDao.getListMemberCnt(search);
    }

    public MEMBER get(MEMBER member){
        MEMBER result = memberDao.getMember(member);
        setDetailInfo(result);
        return result;
    }

    private void setDetailInfo(MEMBER member) {

    }

    public MEMBER getMemberByCol(MEMBER member){
        MEMBER result = memberDao.getMemberByCol(member);
        if(member.getMember() != null){
            setDetailInfo(result);
        }
        return result;
    }

    public Integer save(MEMBER member) {
        // 비밀번호 암호화
        member.setPassword(encoder.encode(member.getPassword()));
        member.setRole(ROLE.ROLE_USER);

        Integer result = memberDao.insertMember(member);
        return result;
    }

    public Integer modify(MEMBER member) {
        if(member.getPassword() != null){
            member.setPassword(encoder.encode(member.getPassword()));
        }
        return memberDao.updateMember(member);
    }

    public Integer remove(MEMBER member) {
        return memberDao.deleteMember(member);
    }
}
