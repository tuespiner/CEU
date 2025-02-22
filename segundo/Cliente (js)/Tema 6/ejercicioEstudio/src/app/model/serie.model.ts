export interface serie{
    id: number,
    url: string,
    name: string,
    type: string,
    language: string,
    genres: string[],
    status: string,
    runtime: number,
    averageRuntime: number,
    premiered: string,
    ended: boolean,
    officialSite: string,
    schedule: {
        time: string,
        days: string[]
    },
    ratin: {
        average: number
    },
    
}