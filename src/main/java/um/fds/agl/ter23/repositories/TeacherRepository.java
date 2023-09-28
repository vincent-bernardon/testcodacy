package um.fds.agl.ter23.repositories;

import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import um.fds.agl.ter23.entities.Teacher;

public interface TeacherRepository extends UserBaseRepository<Teacher> {
    @Override
    @PreAuthorize("hasRole('ROLE_MANAGER') and (#teacher?.terManager == null or #teacher?.terManager?.lastName == authentication?.name)")
    <S extends Teacher> S save(@Param("teacher") S teacher);

    @Override
    @PreAuthorize("@teacherRepository.findById(#id).get()?.terManager?.lastName == authentication?.name")
    void deleteById(@Param("id") Long id);

    @Override
    Optional<Teacher> findById(@Param("id") Long id);

    @Override
    @PreAuthorize("#teacher?.terManager?.lastName == authentication?.name")
    void delete(@Param("teacher") Teacher teacher);
}
