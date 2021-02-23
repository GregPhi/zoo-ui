import axios from 'axios';

const INFO_API_BASE_URL = "http://localhost:8080/zoo-api/infos/";

class InfoService {

    getAllInfos(){
        return axios.get(INFO_API_BASE_URL);
    }

    createInfo(info){
        return axios.post(INFO_API_BASE_URL, info);
    }

    getInfoById(infoId){
        return axios.get(INFO_API_BASE_URL + infoId);
    }

    updateInfo(info, infoId){
        return axios.put(INFO_API_BASE_URL + info, infoId);
    }

    deleteInfo(infoId){
        return axios.delete(INFO_API_BASE_URL + infoId);
    }
}

export default new InfoService()
