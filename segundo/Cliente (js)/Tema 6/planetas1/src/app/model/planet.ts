export interface planet{
    count: number
    next: string
    previos: any
    results: result[]
}
export interface result{
    name: string
    retation_period: string
    orbital_period: string
    diameter: string
    climate: string
    gravity: string
    terrain: string
    surface_water: string
    poppulation: string
    residents: string[]
    films: string[]
    created: string
    edited: string
    url: string
}