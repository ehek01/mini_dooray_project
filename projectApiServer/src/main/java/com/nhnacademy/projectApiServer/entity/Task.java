package com.nhnacademy.projectApiServer.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @EmbeddedId
    private Id taskId;

    /**
     *  todo : @JoinColumns 를 했다는 것은 부모 복합키를 사용하겠다는 말인데..
     *          밑에 Id class 에서 @Column 을 붙힌건 고유 복합키를 사용할 때 하는 행위인데..
     *          아무리 생각해도 고유 복합키는 아닌 것 같은데..
     *          그렇다고 파란키 1개 분홍키 1개도 뭔가 좀 이상한데..
     *          어떻게 설정을 해줘야 하지??
     *          ----------------------------------------------------------------
     *          결과는 역시나 터졌다. 내가 시도한 방법들을 설명하겠다.
     *          1. 우선 projectMember 는 복합키 이므로 관계설정에서 @JoinColumns 를 통해 두개를 외래키로 맵핑하였다.
     *              하지만 @JoinColumn 만 해주면 둘다 분홍키를 쓸 것이라는 이야이가 된다. 따라서,
     *              member_id 는 노란키로 쓸 것이므로 task_id 와 같이 복합키로 맵핑 해 주었다.
     *              결과는? -> member_id 가 겹친다고 에러가 났다.
     *          2. erd cloud 에 보니 복합키를 분홍키로 상속받아서 하나만 pk로 올려주니 파란키가 되는것이 아니라 노란키로 변했다.
     *              하지만 하나남은 분홍키를 클릭해보니 복합키 전체가 참조되는 것을 확인할 수 있었다. 따라서,
     *              @JoinCoulmns 가 아닌 @JoinColumn 으로 하나남은 분홍키만 연관관계를 맺어 주었다.
     *              결과는? -> ProjectMember Entity 와 연관관계를 맺기 위해선 필요한 컬럼이 2개인데 왜 하나의 컬럼만 조인하냐고 에러가 났다.
     *          **나는 이제 어떻게 해야 하는가????**
     */
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "member_id"),
            @JoinColumn(name = "project_id")
    })
    public ProjectMember projectMember;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_create_dt")
    private LocalDateTime createDt;

    @Column(name = "task_expected_complete_dt")
    private LocalDateTime expectedCompleteDt;

    @Column(name = "task_completed_dt")
    private LocalDateTime completedDt;

    @EqualsAndHashCode
    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Id implements Serializable {
        @Column(name = "task_id")
        private Long taskId;

        private Long memberId;
    }
}

