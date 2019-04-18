package com.spring.estate.service.impl;



import com.spring.estate.constant.SystemConstant;
import com.spring.estate.dto.MyUserDetail;
import com.spring.estate.entity.RoleEntity;
import com.spring.estate.entity.UserEntity;
import com.spring.estate.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity item: userEntity.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(item.getCode()));
        }
        MyUserDetail myUserDetail = new MyUserDetail(userEntity.getUserName(), userEntity.getPassword(), authorities);
        BeanUtils.copyProperties(userEntity, myUserDetail);
        return myUserDetail;
    }
}
