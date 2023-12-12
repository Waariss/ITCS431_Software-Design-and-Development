/**
* Template Name: Arsha
* Updated: Mar 10 2023 with Bootstrap v5.2.3
* Template URL: https://bootstrapmade.com/arsha-free-bootstrap-html-template-corporate/
* Author: BootstrapMade.com
* License: https://bootstrapmade.com/license/
*/
(function() {
  "use strict";

  /**
   * Easy selector helper function
   */
  const select = (el, all = false) => {
    el = el.trim()
    if (all) {
      return [...document.querySelectorAll(el)]
    } else {
      return document.querySelector(el)
    }
  }

  /**
   * Easy event listener function
   */
  const on = (type, el, listener, all = false) => {
    let selectEl = select(el, all)
    if (selectEl) {
      if (all) {
        selectEl.forEach(e => e.addEventListener(type, listener))
      } else {
        selectEl.addEventListener(type, listener)
      }
    }
  }

  /**
   * Easy on scroll event listener 
   */
  const onscroll = (el, listener) => {
    el.addEventListener('scroll', listener)
  }

  /**
   * Navbar links active state on scroll
   */
  let navbarlinks = select('#navbar .scrollto', true)
  const navbarlinksActive = () => {
    let position = window.scrollY + 200
    navbarlinks.forEach(navbarlink => {
      if (!navbarlink.hash) return
      let section = select(navbarlink.hash)
      if (!section) return
      if (position >= section.offsetTop && position <= (section.offsetTop + section.offsetHeight)) {
        navbarlink.classList.add('active')
      } else {
        navbarlink.classList.remove('active')
      }
    })
  }
  window.addEventListener('load', navbarlinksActive)
  onscroll(document, navbarlinksActive)

  /**
   * Scrolls to an element with header offset
   */
  const scrollto = (el) => {
    let header = select('#header')
    let offset = header.offsetHeight

    let elementPos = select(el).offsetTop
    window.scrollTo({
      top: elementPos - offset,
      behavior: 'smooth'
    })
  }

  /**
   * Toggle .header-scrolled class to #header when page is scrolled
   */
  let selectHeader = select('#header')
  if (selectHeader) {
    const headerScrolled = () => {
      if (window.scrollY > 100) {
        selectHeader.classList.add('header-scrolled')
      } else {
        selectHeader.classList.remove('header-scrolled')
      }
    }
    window.addEventListener('load', headerScrolled)
    onscroll(document, headerScrolled)
  }

  /**
   * Back to top button
   */
  let backtotop = select('.back-to-top')
  if (backtotop) {
    const toggleBacktotop = () => {
      if (window.scrollY > 100) {
        backtotop.classList.add('active')
      } else {
        backtotop.classList.remove('active')
      }
    }
    window.addEventListener('load', toggleBacktotop)
    onscroll(document, toggleBacktotop)
  }

  /**
   * Mobile nav toggle
   */
  on('click', '.mobile-nav-toggle', function(e) {
    select('#navbar').classList.toggle('navbar-mobile')
    this.classList.toggle('bi-list')
    this.classList.toggle('bi-x')
  })

  /**
   * Mobile nav dropdowns activate
   */
  on('click', '.navbar .dropdown > a', function(e) {
    if (select('#navbar').classList.contains('navbar-mobile')) {
      e.preventDefault()
      this.nextElementSibling.classList.toggle('dropdown-active')
    }
  }, true)

  /**
   * Scrool with ofset on links with a class name .scrollto
   */
  on('click', '.scrollto', function(e) {
    if (select(this.hash)) {
      e.preventDefault()

      let navbar = select('#navbar')
      if (navbar.classList.contains('navbar-mobile')) {
        navbar.classList.remove('navbar-mobile')
        let navbarToggle = select('.mobile-nav-toggle')
        navbarToggle.classList.toggle('bi-list')
        navbarToggle.classList.toggle('bi-x')
      }
      scrollto(this.hash)
    }
  }, true)

  /**
   * Scroll with ofset on page load with hash links in the url
   */
  window.addEventListener('load', () => {
    if (window.location.hash) {
      if (select(window.location.hash)) {
        scrollto(window.location.hash)
      }
    }
  });

  /**
   * Preloader
   */
  let preloader = select('#preloader');
  if (preloader) {
    window.addEventListener('load', () => {
      preloader.remove()
    });
  }

  /**
   * Initiate  glightbox 
   */
  const glightbox = GLightbox({
    selector: '.glightbox'
  });

  /**
   * Skills animation
   */
  let skilsContent = select('.skills-content');
  if (skilsContent) {
    new Waypoint({
      element: skilsContent,
      offset: '80%',
      handler: function(direction) {
        let progress = select('.progress .progress-bar', true);
        progress.forEach((el) => {
          el.style.width = el.getAttribute('aria-valuenow') + '%'
        });
      }
    })
  }

  /**
   * Porfolio isotope and filter
   */
  window.addEventListener('load', () => {
    let portfolioContainer = select('.portfolio-container');
    if (portfolioContainer) {
      let portfolioIsotope = new Isotope(portfolioContainer, {
        itemSelector: '.portfolio-item'
      });

      let portfolioFilters = select('#portfolio-flters li', true);

      on('click', '#portfolio-flters li', function(e) {
        e.preventDefault();
        portfolioFilters.forEach(function(el) {
          el.classList.remove('filter-active');
        });
        this.classList.add('filter-active');

        portfolioIsotope.arrange({
          filter: this.getAttribute('data-filter')
        });
        portfolioIsotope.on('arrangeComplete', function() {
          AOS.refresh()
        });
      }, true);
    }

  });

  /**
   * Initiate portfolio lightbox 
   */
  const portfolioLightbox = GLightbox({
    selector: '.portfolio-lightbox'
  });

  /**
   * Portfolio details slider
   */
  new Swiper('.portfolio-details-slider', {
    speed: 400,
    loop: true,
    autoplay: {
      delay: 5000,
      disableOnInteraction: false
    },
    pagination: {
      el: '.swiper-pagination',
      type: 'bullets',
      clickable: true
    }
  });

  /**
   * Animation on scroll
   */
  window.addEventListener('load', () => {
    AOS.init({
      duration: 1000,
      easing: "ease-in-out",
      once: true,
      mirror: false
    });
  });

})()

// get all sci plan to show test
$(document).ready(function () {
  const requestUrl = "/api/science_plan";

  fetch(requestUrl)
      .then(response => {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error('Error fetching science plan data');
        }
      })
      .then(data => {
        console.log(`Science Plan Data: ${JSON.stringify(data)}`);
        const planNoDropdown = document.getElementById("planNo");
        data.forEach(plan => {
          const option = document.createElement("option");
          option.value = plan.planNo;
          option.textContent = `Plan ${plan.planNo}: ${plan.starSystem}`;
          planNoDropdown.add(option);
        });
      })
      .catch(error => {
        console.error('Error:', error);
      });

  // get sci plan with planNo
  $("#planNo").on("change", function () {
    var planNo = $("#planNo").val();
    if (planNo != "") {
      const requestUrl = "/api/science_plan/" + planNo;
      console.log(`Plan No: ${planNo}`);
      console.log(`Request URL: ${requestUrl}`);

      fetch(requestUrl)
          .then(response => {
            if (response.ok) {
              return response.json();
            } else {
              throw new Error('Error fetching science plan data');
            }
          })
          .then(data => {
            console.log(`Science Plan Data: ${JSON.stringify(data)}`);
            $("#creator-value").text(data.creator);
            $("#submitter-value").text(data.submitter);
            $("#fundingInUSD-value").text(data.fundingInUSD);
            $("#starSystem-value").text(data.starSystem);
            $("#startDate-value").text(data.startDate);
            $("#endDate-value").text(data.endDate);
            $("#telescopeLocation-value").text(data.telescopeLocation);
            document.querySelector("#testBtn").style.display = "inline-block";

            // Fetch the status
            const statusRequestUrl = "/api/science_plan/status/" + planNo;
            fetch(statusRequestUrl)
                .then(response => {
                  if (response.ok) {
                    return response.text();
                  } else {
                    throw new Error('Error fetching science plan status');
                  }
                })
                .then(status => {
                  console.log(`Science Plan Status: ${status}`);
                  $("#status-value").text(status);
                })
                .catch(error => {
                  console.error('Error:', error);
                });

            $("#science-plan-data").show();
          })
          .catch(error => {
            console.error('Error:', error);
          });
    } else {
      $("#science-plan-data").hide();
    }
  });
});

// get all Telescope Locations
document.addEventListener('DOMContentLoaded', function() {
  fetch('/api/science_plan/telescopelocations')
      .then(response => response.json())
      .then(data => {
        const starSystemSelect = document.getElementById('telescopeLocation');
        data.forEach(starSystem => {
          const option = document.createElement('option');
          option.value = starSystem;
          option.textContent = starSystem;
          starSystemSelect.appendChild(option);
        });
      })
      .catch(error => console.error(error));
});

// get all Star System
document.addEventListener('DOMContentLoaded', function() {
  fetch('/api/science_plan/starsystems')
      .then(response => response.json())
      .then(data => {
        const starSystemSelect = document.getElementById('starSystem');
        data.forEach(starSystem => {
          const option = document.createElement('option');
          option.value = starSystem;
          option.textContent = starSystem;
          starSystemSelect.appendChild(option);
        });
      })
      .catch(error => console.error(error));
});

document.addEventListener('DOMContentLoaded', function () {
  fetchSciencePlans();
});

// get all sci plan
function fetchSciencePlans() {
  fetch('/api/science_plan') // Replace with your API endpoint
      .then(response => response.json())
      .then(sciencePlans => {
        displaySciencePlans(sciencePlans);
      })
      .catch(error => {
        console.error('Error fetching science plans:', error);
      });
}
function displaySciencePlans(sciencePlans) {
  const tableBody = document.getElementById('science-plans-table');
  tableBody.innerHTML = '';

  sciencePlans.forEach(plan => {
    const row = document.createElement('tr');

    const creatorCell = document.createElement('td');
    creatorCell.textContent = plan.creator;
    row.appendChild(creatorCell);

    const submitterCell = document.createElement('td');
    submitterCell.textContent = plan.submitter;
    row.appendChild(submitterCell);

    const fundingCell = document.createElement('td');
    fundingCell.textContent = plan.fundingInUSD;
    row.appendChild(fundingCell);

    const starSystemCell = document.createElement('td');
    starSystemCell.textContent = plan.starSystem;
    row.appendChild(starSystemCell);

    const startDateCell = document.createElement('td');
    startDateCell.textContent = plan.startDate;
    row.appendChild(startDateCell);

    const endDateCell = document.createElement('td');
    endDateCell.textContent = plan.endDate;
    row.appendChild(endDateCell);

    const telescopeLocationCell = document.createElement('td');
    telescopeLocationCell.textContent = plan.telescopeLocation;
    row.appendChild(telescopeLocationCell);

    const statusCell = document.createElement('td');
    statusCell.textContent = plan.status;
    row.appendChild(statusCell);

    tableBody.appendChild(row);
  });
}

// test science plan
$("#testBtn").click(function () {
  var planNo = $("#planNo").val();
  if (planNo != "") {
    const testRequestUrl = "/api/science_plan/test/" + planNo;
    console.log(`Test Request URL: ${testRequestUrl}`);
    // Show the loading message
    $("#loadingMessage").show();

    fetch(testRequestUrl)
        .then(response => {
          if (response.ok) {
            return response.text();
          } else {
            throw new Error('Error fetching test results');
          }
        })
        .then(data => {
          console.log(`Test Results: ${data}`);
          // Hide the loading message and show the test results
          $("#loadingMessage").hide();
          $("#testResultsContent").text(data);
          $("#testResults").show();
        })
        .catch(error => {
          console.error('Error:', error);
        });
  }
});

// sumbit science plan
function populateDropdown() {
  fetch("/api/science_plan")
      .then(response => {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error("Error fetching science plans");
        }
      })
      .then(plans => {
        const testedPlans = plans.filter(plan => plan.status === "TESTED");
        const dropdown = document.querySelector("#planNo1");

        if (testedPlans.length > 0) {
          testedPlans.forEach(plan => {
            const option = document.createElement("option");
            option.value = plan.planNo;
            option.textContent = `Plan ${plan.planNo}: ${plan.starSystem}`;
            dropdown.appendChild(option);
          });
        } else {
          document.querySelector("#TEST").style.display = "none";
          document.querySelector("#Plstest").style.display = "block";
        }
      })
      .catch(error => {
        console.error("Error:", error);
      });
}

// Call the function to populate the dropdown on page load
populateDropdown();
document.querySelector("#planNo1").addEventListener("change", function () {
  var planNo = this.value;
  if (planNo != "") {
    fetch("/api/science_plan" + "/" + planNo)
        .then(response => {
          if (response.ok) {
            return response.json();
          } else {
            throw new Error("Error fetching science plan data");
          }
        })
        .then(data => {
          document.querySelector("#creator-value1").textContent = data.creator;
          document.querySelector("#submitter-value1").textContent = data.submitter;
          document.querySelector("#fundingInUSD-value1").textContent = data.fundingInUSD;
          document.querySelector("#starSystem-value1").textContent = data.starSystem;
          document.querySelector("#startDate-value1").textContent = data.startDate;
          document.querySelector("#endDate-value1").textContent = data.endDate;
          document.querySelector("#telescopeLocation-value1").textContent = data.telescopeLocation;
          document.querySelector("#status-value1").textContent = data.status;

          document.querySelector("#science-plan-data1").style.display = "block";
          document.querySelector("#submitBtn").style.display = "inline-block"; // Show the "Submit Science Plan" button
        })
        .catch(error => {
          console.error("Error:", error);
        });
  } else {
    console.log("No science plan selected.");
  }
});

$("#submitBtn").click(function () {
  const planNo = document.querySelector("#planNo1").value;
  if (planNo !== "") {
    const testRequestUrl = "/api/science_plan/submit/" + planNo;
    console.log(`Test Request URL: ${testRequestUrl}`);
    // Show the loading message
    $("#loadingMessage1").show();

    fetch(testRequestUrl)
        .then(response => {
          if (response.ok) {
            return response.text();
          } else {
            throw new Error('Error fetching test results');
          }
        })
        .then(data => {
          console.log(`Test Results: ${data}`);
          // Hide the loading message and show the test results
          $("#loadingMessage1").hide();
          $("#testResultsContent1").text(data);
          $("#testResults1").show();
        })
        .catch(error => {
          console.error('Error:', error);
        });
  }
});

$(document).ready(function() {
  $('#science-plan-form').on('submit', function(event) {
    event.preventDefault();
    const formData = $(this).serializeArray();
    const jsonData = {dataProcRequirements: {}};

    $.each(formData, function(i, field) {
      if (field.name.startsWith('dataProcRequirements[')) {
        const key = field.name.slice(21, -1);
        jsonData.dataProcRequirements[key] = field.value;
      } else {
        jsonData[field.name] = field.value;
      }
    });

    console.log(jsonData); // Inspect the jsonData object

    $.ajax({
      url: '/api/science_plan',
      type: 'POST',
      contentType: 'application/json',
      data: JSON.stringify(jsonData),
      success: function(response) {
        // Handle the successful creation of the science plan
        alert('Science plan created successfully!');
      },
      error: function(jqXHR, textStatus, errorThrown) {
        // Handle errors during the creation of the science plan
        alert('Error creating science plan: ' + errorThrown);
      }
    });
  });
});











