import React, { Component } from 'react'
import { Layout, Menu, Table } from 'antd';

const { Header, Content, Footer } = Layout;
const navTabs = ['Dashboard', 'Search', 'Misc'];

const url = 'http://localhost:8080/sensors/'

const columns = [
    {
        title: 'Entry Id',
        dataIndex: 'entryId',
        key: 'entryId',
    },
    {
        title: 'Id',
        dataIndex: 'id',
        key: 'id',
    },
    {
        title: 'Data',
        dataIndex: 'data',
        key: 'data',
    },
    {
        title: 'Time Stamp',
        dataIndex: 'timestamp',
        key: 'timestamp',
    },
    {
        title: 'Type',
        dataIndex: 'type',
        key: 'type',
    },
];

const onClick = (e) => {
    console.log('click', e);
    if(e.key === navTabs[0])
        window.location.replace('http://localhost:3000/')
    else if(e.key === navTabs[1])
    window.location.replace('http://localhost:3000/search')
    else if(e.key === navTabs[2])
    window.location.replace('http://localhost:3000/misc')
}

class Dashboard extends Component {
    // Create a request variable and assign a new XMLHttpRequest object to it. 
    constructor(props) {
        super(props);
        this.state = {
            entries: [],
        }
    };

    toggleCollapsed = () => {
        this.setState({ collapsed: !this.state.collapsed });
    };

    loadEntry() {
        fetch(url, {
            method: 'GET',
            withCredentials: true,
            credentials: 'include',
            crossorigin: true,
        })
            .then((result) => result.json())
            .then((json) => {
                this.setState({
                    entries: json,
                });
                console.log(this.state);
            })
            .catch(e => {
                console.log(e);
                window.location.replace('http://localhost:8080/login')
            });
    }


    removeEntry(entryId) {

        fetch(url + 'deleteEntry/' + entryId, {
            method: 'GET',
            withCredentials: true,
            credentials: 'include',
            crossorigin: true,
        }).then((result) => result.json())
            .then((json) => {
                console.log(this.state);
                this.setState({
                    entries: this.state.entries.filter(function (data) {
                        return data.entryId !== json
                    }),
                })
            })
            .catch(e => {
                console.log(e);
            });

    }

    componentDidMount() {
        this.loadEntry();
    }

    render() {
        //const { entries } = this.state
        return (<>
            <Layout className="layout">
                <Header>
                    <div className="logo" />
                    <Menu
                        theme="dark"
                        mode="horizontal"
                        onClick={onClick}
                        defaultSelectedKeys={[navTabs[0]]}
                        items={new Array(3).fill(null).map((_, index) => {
                            const key = navTabs[index];
                            return {
                                key,
                                label: `${key}`,
                            };
                        })}
                    />
                </Header>
                <Content
                    style={{
                        padding: '0 50px',
                    }}
                >
                    <div className="TableData">
                        <h1> Complete Sensor data </h1>  {
                            <Table dataSource={this.state.entries} columns={columns} />
                        }
                    </div>
                </Content>
                <Footer
                    style={{
                        textAlign: 'center',
                    }}
                >
                    Ant Design ©2023 Created by Torres
                </Footer>
            </Layout>
        </>);
    }
}
export default Dashboard