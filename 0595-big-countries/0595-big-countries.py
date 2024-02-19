import pandas as pd

def big_countries(world: pd.DataFrame) -> pd.DataFrame:
    filt = (world['area'] >= 3000000) | (world['population'] >= 25000000)
    result = world.loc[filt, ['name','population','area']]
    return result