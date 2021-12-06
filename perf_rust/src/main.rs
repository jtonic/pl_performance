//! `cargo run --example blocking --features=blocking`
// #![deny(warnings)]

use log::{info};
use chrono::{Utc, TimeZone};
use chrono::prelude::*;

fn main() -> Result<(), Box<dyn std::error::Error>> {
    env_logger::init();

    let _before: f64 = Local::now().timestamp_millis() as f64;

    info!("GET https://www.google.com");

    let res = reqwest::blocking::get("https://www.google.com/")?;

    info!("Status: {}", res.status());
    info!("Headers:\n{:?}", res.headers());

    // copy the response body directly to stdout
    // res.copy_to(&mut std::io::stdout())?;

    let _after: f64 = Local::now().timestamp_millis() as f64;

    let elapsed: f64 = (_after - _before) / 1_000.0;

    print!("\n\nElapsed: {} seconds.\n\n", elapsed);
    info!("\n\nElapsed: {} seconds.\n\n", elapsed);
    Ok(())
}

