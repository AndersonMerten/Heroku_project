export class Contact {
  _id?: string;
  name: string;
  email: string;
  Telefone: {
    celular: string;
    residencial: string;
  }
  valorDevido: number;
  observacoes: string;

}