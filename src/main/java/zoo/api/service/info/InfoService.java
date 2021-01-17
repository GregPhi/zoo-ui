package zoo.api.service.info;

import zoo.api.bo.info.Info;

import java.util.List;

public interface InfoService {
    List<Info> findAllInfos();

    Info findInfoById(int id);

    Info addInfo(Info info);

    Info updateInfo(Info info);

    void deleteInfo(Info info);
}
